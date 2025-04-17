plugins {
    `java-library`
}

dependencies {
    api(project(":store"))

    // Swagger 어노테이션만 컴파일용으로 사용 (UI X)
    compileOnly("org.springdoc:springdoc-openapi-starter-webmvc-api:2.1.0")
}