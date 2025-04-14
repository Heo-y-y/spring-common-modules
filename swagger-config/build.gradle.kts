plugins {
    id("java-library")
}

dependencies {
    // springdoc OpenAPI
    api("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // 스프링 context 사용
    implementation("org.springframework:spring-context")
}
