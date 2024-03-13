# Multi Stage build

# Base Image and name stage as "builder"
FROM maven:3.9.6 AS builder

USER root

# Create App Directory inside our container
WORKDIR /student/app/src/

# Copy files
COPY src ./
COPY pom.xml ../

RUN mvn -f /student/app/pom.xml clean package -Dmaven.test.skip

#### 2nd Stage ####

FROM openjdk:21

WORKDIR /student/lib/

# Copy the Jar from the first Stage (builder) to the 2nd stage working directory
COPY --from=builder /student/app/target/student-0.0.1-SNAPSHOT.jar ./dockerized-student.jar

# Expose the port to the inner container communication network
EXPOSE 8282

# Run the Java Application
ENTRYPOINT [ "java","-jar","/student/lib/dockerized-student.jar"]