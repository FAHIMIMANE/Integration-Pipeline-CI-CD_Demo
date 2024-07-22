FROM openjdk:17
WORKDIR /app
COPY backend-ms1/target/*.jar app.jar
EXPOSE 8036
ENTRYPOINT ["java","-jar","app.jar"]