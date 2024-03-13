# Multi Stage build

# Base Image and name stage as "builder"
FROM maven:3.9.6 AS builder

USER root

# Create App Directory inside our container
WORKDIR /school/app/src/

# Copy files
COPY src ./
COPY pom.xml ../

RUN mvn -f /school/app/pom.xml clean package -Dmaven.test.skip

#### 2nd Stage ####

FROM openjdk:21

WORKDIR /school/lib/

# Copy the Jar from the first Stage (builder) to the 2nd stage working directory
COPY --from=builder /school/app/target/school-0.0.1-SNAPSHOT.jar ./dockerized-school.jar

# Expose the port to the inner container communication network
EXPOSE 8181

# Run the Java Application
ENTRYPOINT [ "java","-jar","/school/lib/dockerized-school.jar"]