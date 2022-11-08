plugins {
    id("com.kotlinmonorepo.kotlin-common-conventions")
}

group = "com.kotlinmonorepo"
version = "0.0.1"

dependencies {
    implementation("io.dropwizard:dropwizard-core:2.1.1")
    implementation("io.dropwizard:dropwizard-client:2.1.1")
    implementation("io.dropwizard:dropwizard-testing:2.1.1")
    implementation("org.glassfish.jersey.inject:jersey-hk2:2.26")
    testImplementation("org.assertj:assertj-core:3.23.1")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.kotlinmonorepo.dropwizardapp.DropWizardApp"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

tasks.register<JavaExec>("start") {
    classpath = files("build/libs/dropwizardapp-${version}.jar")
    args("server", "config.yml")
}
