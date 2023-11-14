FROM tomcat:latest
#FROM tomcat:10-jdk17-openjdk-buster
ADD target/*.war /usr/local/tomcat/webapps
EXPOSE 9090
CMD ["catalina.sh", "run"]