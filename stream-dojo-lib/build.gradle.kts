plugins {
    id("java-library")
}

java {
    toolchain {
        // Install JDK with specific version
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.0.1-jre")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}
