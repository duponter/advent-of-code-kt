import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.7.21"

    // Apply the application plugin to add support for building a CLI application.
    application
}

repositories {
    // Use jcenter for resolving dependencies.
    // You can declare any Maven/Ivy/file repository here.
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.19")

    testImplementation("org.spekframework.spek2:spek-runner-junit5:2.0.19")

}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = "17" }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
