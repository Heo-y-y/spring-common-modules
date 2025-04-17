plugins {
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.6"
    java
}

dependencies {
    implementation(project(":service"))

    // Swagger UI + OpenAPI 3.0 문서 자동 생성
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

    // Jackson 날짜 지원(Spring Boot BOM 버전으로 자동 관리)
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    // AOP
    implementation("org.springframework.boot:spring-boot-starter-aop")
}