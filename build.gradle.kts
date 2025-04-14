plugins {
    id("io.spring.dependency-management") version "1.1.7"
    java
}

group = "com.heoyy"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

// 하위 모듈 공통 설정
subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "java-library") // 다른 모듈에서 api/export 의존성 쓸 수 있도록

    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    // 테스트 플랫폼 공통 적용
    tasks.withType<Test> {
        useJUnitPlatform()
    }

    // 공통 의존성
    dependencies {
        implementation(platform("org.springframework.boot:spring-boot-dependencies:3.2.5"))

        compileOnly("org.projectlombok:lombok:1.18.30")
        annotationProcessor("org.projectlombok:lombok:1.18.30")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}
