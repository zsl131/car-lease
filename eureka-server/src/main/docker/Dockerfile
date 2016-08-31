FROM java:8
EXPOSE 8762

ADD run.sh /run.sh

RUN chmod +x /run.sh

ADD eureka-server-*.jar /eureka-server.jar

ENTRYPOINT sh /run.sh