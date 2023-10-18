#FROM yannoff/maven:3-openjdk-19 AS build
#COPY . .
#RUN mvn clean install package -DskipTests

FROM fundingsocietiesdocker/openjdk19-alpine
LABEL authors="olusolabadmus"
ADD target/*jar blog.jar
ENTRYPOINT ["java", "-jar", "blog.jar"]