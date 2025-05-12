# 1단계: 빌드용 이미지 (Gradle + JDK 17)
FROM gradle:8.4-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle boot:bootJar --no-daemon

# 2단계: 실행용 이미지 (경량 JRE)
FROM eclipse-temurin:17-jre
WORKDIR /app

# JAR 복사
COPY --from=builder /app/boot/build/libs/*.jar app.jar

# JVM 옵션 (옵션)
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"

# 실행
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
