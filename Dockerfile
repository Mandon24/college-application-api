# Step 1: Use an official OpenJDK image as the base
FROM amazoncorretto:21
LABEL authors="andon"

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the Maven build file and the source code to the container
COPY pom.xml /app
COPY src /app/src

# Step 4: Copy the JAR file to the app directory
COPY target/*.jar /app/college-app.jar

CMD apt-get update -y

# Step 5: Specify the command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/college-app.jar"]