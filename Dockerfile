
FROM maven:3.8.3-openjdk-17 as build

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/mambo-v1-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]