FROM eclipse-temurin:17-jdk-alpine
COPY target/app2.jar /app2.jar
ENTRYPOINT ["java","-jar","/app2.jar"]
EXPOSE 8080