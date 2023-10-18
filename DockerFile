FROM yannoff/maven:3-openjdk-19 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:19-alpine
LABEL authors="olusolabadmus"
COPY --from=build /target/blog-0.0.1-SNAPSHOT.jar blog.jar
ENTRYPOINT ["java", "-jar", "blog.jar"]

#ADD target/*jar blog.jar
