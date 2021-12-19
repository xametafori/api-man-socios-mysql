FROM openjdk:11
VOLUME /tmp
EXPOSE 8096
ADD ./target/api-man-socios-mysql-0.0.1-SNAPSHOT.jar api-man-socios-mysql.jar
ENTRYPOINT ["java","-jar","/api-man-socios-mysql.jar"]