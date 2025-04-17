import org.gradle.api.JavaVersion
import org.gradle.api.tasks.compile.JavaCompile

plugins {
    java
    id("io.spring.dependency-management") version "1.1.6"
}

val springBootVersion = "3.0.6"
val springBootDependenciesVersion = "3.0.4"
val springBootStarterWebVersion = "3.0.4"
val lombokVersion = "1.18.26"
val mysqlConnectorVersion = "8.0.33"

allprojects {
    group = "com.nuri.medrcalc"
    version = "1.0.0-SNAPSHOT"
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "java-library")
    apply(plugin = "io.spring.dependency-management")

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    tasks.withType<JavaCompile>().configureEach {
        options.encoding = "UTF-8"
        options.compilerArgs.add("-parameters")
    }

    sourceSets["main"].resources {
        srcDir("src/main/resources")
        include("**/*.xml")
    }

    repositories {
        mavenCentral()
    }

    configurations.configureEach {
        if (this.name == "compileOnly") {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    dependencies {
        // Core Spring
        implementation("org.springframework.boot:spring-boot-starter-web:$springBootStarterWebVersion")
        implementation(platform("org.springframework.boot:spring-boot-dependencies:$springBootDependenciesVersion"))

        // Web + Validation
        implementation("org.springframework:spring-web:6.0.8")
        implementation("org.springframework.boot:spring-boot-starter-validation:$springBootStarterWebVersion")

        // Lombok
        compileOnly("org.projectlombok:lombok:$lombokVersion")
        annotationProcessor("org.projectlombok:lombok:$lombokVersion")
    }
}

tasks.register<Delete>("cleanLogs") {
    delete("logs")
}

tasks.named("clean") {
    dependsOn("cleanLogs")
}
