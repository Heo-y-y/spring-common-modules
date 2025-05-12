# 1단계: 빌드용 이미지
FROM gradle:8.4-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle boot:bootJar --no-daemon

# 2단계: 실행용 이미지 (JRE)
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /app/boot/build/libs/*.jar app.jar

# 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]