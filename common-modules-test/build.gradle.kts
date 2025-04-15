plugins {
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management")
    java
}

dependencies {
    implementation(project(":swagger-config"))
    implementation(project(":core"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}