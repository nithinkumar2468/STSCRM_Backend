FROM openjdk:17
EXPOSE 8080
ADD /target/crm-backend.jar crm-backend.jar
ENTRYPOINT ["java","-jar","/crm-backend.jar"]
