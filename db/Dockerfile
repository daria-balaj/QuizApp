# Use a Maven + JDK image to build the app
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Set working dir
WORKDIR /db

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the code
COPY . .

# Package the app
RUN mvn clean package -DskipTests

# Use a lightweight JRE image to run the app
FROM eclipse-temurin:17-jre-alpine

WORKDIR /db

# Copy the JAR from the build stage (note the change from /app to /db)
COPY --from=build /db/target/*.jar app.jar

# Run it
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the port your Spring Boot app runs on
EXPOSE 8080
