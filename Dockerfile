FROM openjdk:8
VOLUME /gameserver
EXPOSE 8080
ADD target/gameserver.jar gameserver.jar
ENTRYPOINT ["java","-jar","/gameserver.jar"]
