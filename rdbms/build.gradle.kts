import java.time.Clock
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
    // Apply the common convention plugin for shared build configuration between library and application projects.
    id("com.kotlinmonorepo.kotlin-common-conventions")
    id("org.liquibase.gradle") version "2.1.1"
}

group = "com.kotlinmonorepo"
version = "0.0.1"

val changeLog = "rdbms/liquibase/changelog.xml"

buildscript {
    dependencies {
        classpath("org.liquibase:liquibase-core:4.13.0")
        classpath("org.postgresql:postgresql:42.4.0")
    }
}

liquibase {
    activities.register("main") {
        val db_url = "jdbc:postgresql://localhost:5432/kotlin_monorepo"
        val db_user = "postgres"
        this.arguments = mapOf(
            "logLevel" to "info",
            "url" to db_url,
            "username" to db_user,
            "driver" to "org.postgresql.Driver",
            "changeLogFile" to changeLog
        )
    }
    runList = "main"
}

dependencies {
    liquibaseRuntime("org.liquibase:liquibase-core:4.13.0")
    liquibaseRuntime("org.postgresql:postgresql:42.4.0")
    liquibaseRuntime("info.picocli:picocli:4.6.3")
}

tasks.register("createChangeLog")  {
    doFirst {
        if (project.hasProperty("desc")) {
            val desc = project.properties["desc"]
            val current = LocalDateTime.now(Clock.systemUTC())
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")
            val formatted = current.format(formatter)
            val srcFile = File("${projectDir}/liquibase/sample-changelog.xml")
            val newFile = File("${projectDir}/liquibase/evolutions/${formatted}-${desc}.xml")
            srcFile.copyTo(newFile)
            println("File created: ${projectDir}/liquibase/evolutions/${formatted}-${desc}.xml")
            println("Add \"<include file=\"evolutions/${newFile.name}\" relativeToChangelogFile=\"true\"/>\" to ${projectDir}/liquibase/changelog.xml")
        } else {
            println("Provide changelog description!")
        }
    }
}
