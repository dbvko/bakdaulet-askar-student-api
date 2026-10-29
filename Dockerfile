FROM gradle:9.8.2-jdk21 AS build
WORKDIR /app

COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY gradlew ./
RUN chmod +x gradlew

COPY src ./src
RUN ./gradlew clean bootJar --no-daemon

FROM eclipse-temurin:21-jre
WORKDIR /app

RUN useradd --system --create-home appuser
COPY --from=build /app/build/libs/*.jar app.jar

USER appuser
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
