FROM yannoff/maven:3-openjdk-19 AS build
COPY . .
RUN mvn clean install package -DskipTests

FROM openjdk:19-alpine
LABEL authors="olusolabadmus"
ADD target/*jar blog.jar
#COPY --from=build /target/*jar blog.jar
ENTRYPOINT ["java", "-jar", "blog.jar"]
