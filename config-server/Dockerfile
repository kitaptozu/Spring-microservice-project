# Multi Stage build

# Base Image and name stage as "builder"
FROM maven:3.9.6 AS builder

USER root

# Create App Directory inside our container
WORKDIR /configserver/app/src/

# Copy files
COPY src ./
COPY pom.xml ../

RUN mvn -f /configserver/app/pom.xml clean package -Dmaven.test.skip

#### 2nd Stage ####

FROM openjdk:21

WORKDIR /configserver/lib/

# Copy the Jar from the first Stage (builder) to the 2nd stage working directory
COPY --from=builder /configserver/app/target/config-server-0.0.1-SNAPSHOT.jar ./dockerized-configserver.jar

# Expose the port to the inner container communication network
EXPOSE 9292

# Run the Java Application
ENTRYPOINT [ "java","-jar","/configserver/lib/dockerized-configserver.jar"]