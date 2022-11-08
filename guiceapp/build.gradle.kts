plugins {
    id("com.kotlinmonorepo.kotlin-common-conventions")
}

group = "com.kotlinmonorepo"
version = "0.0.1"

dependencies {
    implementation("com.google.inject:guice:5.0.1")
    implementation("com.google.inject.extensions:guice-assistedinject:5.0.1")
    implementation("dev.misfitlabs.kotlinguice4:kotlin-guice:1.6.0")
    implementation("org.jdbi:jdbi3-bom:3.18.1")
    implementation("org.jdbi:jdbi3-core:3.31.0")
    implementation("org.jdbi:jdbi3-guava:3.31.0")
    implementation("org.jdbi:jdbi3-sqlobject:3.31.0")
    implementation("org.jdbi:jdbi3-postgres:3.31.0")
    implementation("org.jdbi:jdbi3-kotlin:3.31.0")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject:3.31.0")
    implementation("org.postgresql:postgresql:42.4.0")
    implementation("org.slf4j:slf4j-simple:2.0.0-alpha7")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.kotlinmonorepo.GuiceApp"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}
