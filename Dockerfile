#FROM tomcat:10.1-jdk11-openjdk
#
#COPY /target/survey-form.war /usr/local/tomcat/webapps/
#
#EXPOSE 8080
#
#CMD ["catalina.sh", "run"]


FROM maven:3.8.3-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src /app/src
RUN mvn package -DskipTests

FROM tomcat:9-jdk11-openjdk-slim
WORKDIR /usr/local/tomcat/webapps
COPY --from=build target/*.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
