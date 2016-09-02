FROM java:8
EXPOSE 8898

ADD run.sh /run.sh

RUN chmod +x /run.sh

ADD api-gateway-*.jar /api-gateway.jar

ENTRYPOINT sh /run.sh