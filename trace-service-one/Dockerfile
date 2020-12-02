# https://hub.docker.com/_/maven
FROM maven:3.6-openjdk-11 as builder

# Copy local code to the container image.
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline


COPY src ./src
RUN mvn -DskipTests package


FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=builder /build/target/trace-service-one*.jar trace-service-one.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "trace-service-one.jar"]
