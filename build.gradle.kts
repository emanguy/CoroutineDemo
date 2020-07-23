plugins {
    kotlin("jvm") version "1.3.72"
    application
}

group = "edu.erittenhouse"
version = "1.0"

repositories {
    mavenCentral()
}

application {
    mainClassName = "edu.erittenhouse.MainKt"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}