# Multi Stage build

# Base Image and name stage as "builder"
FROM maven:3.9.6 AS builder

USER root

# Create App Directory inside our container
WORKDIR /discovery/app/src/

# Copy files
COPY src ./
COPY pom.xml ../

RUN mvn -f /discovery/app/pom.xml clean package -Dmaven.test.skip

#### 2nd Stage ####

FROM openjdk:21

WORKDIR /discovery/lib/

# Copy the Jar from the first Stage (builder) to the 2nd stage working directory
COPY --from=builder /discovery/app/target/discovery-0.0.1-SNAPSHOT.jar ./dockerized-discovery.jar

# Expose the port to the inner container communication network
EXPOSE 9090

# Run the Java Application
ENTRYPOINT [ "java","-jar","/discovery/lib/dockerized-discovery.jar"]