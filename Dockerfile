#FROM tomcat:10.1-jdk11-openjdk
#
#COPY /target/survey-form.war /usr/local/tomcat/webapps/
#
#EXPOSE 8080
#
#CMD ["catalina.sh", "run"]

# Use official Tomcat runtime as a parent image
FROM tomcat:9.0.31-jdk8-openjdk

# Copy the war file into the container
COPY target/*.war /usr/local/tomcat/webapps/

# Expose port 8080 for the container
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]
