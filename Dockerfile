# Step 1: Use an official OpenJDK image as the base
FROM eclipse-temurin:17-jdk-jammy

# Step 2: Set a working directory inside the container
WORKDIR /app

# Step 3: Copy the built JAR from your target folder to the container,Docker command to copy files from your local project into the Docker container.
COPY target/employee-crud-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port your Spring Boot app runs on (default 8080)
EXPOSE 8080

# Step 5: Command to run your Spring Boot JAR,entrypoint means tells Docker how to start your app when the container launches.
ENTRYPOINT ["java","-jar","app.jar"]
