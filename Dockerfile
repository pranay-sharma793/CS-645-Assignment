FROM tomcat:10.1-jdk11-openjdk

COPY /target/survey-form.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]