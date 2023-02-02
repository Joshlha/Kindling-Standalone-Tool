
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "io.github.joshlha"
version = "0.0.1"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io/")
    maven {
        name = "Kindling"
        url = uri("https://maven.pkg.github.com/paul-griffith/kindling")
        credentials {
            username = System.getenv("GITHUB_USER")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
    maven {
        url = uri("https://nexus.inductiveautomation.com/repository/inductiveautomation-releases/")
    }
    maven {
        url = uri("https://nexus.inductiveautomation.com/repository/inductiveautomation-thirdparty/")
    }
}

dependencies {
    implementation(libs.kindling)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get().toInt()))
    }
}

kotlin {
    jvmToolchain(libs.versions.java.get().toInt())
}

application {
    mainClass.set("io.github.paulgriffith.kindling.MainPanel")
}