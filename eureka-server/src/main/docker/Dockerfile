FROM java:8
EXPOSE 8762

ADD run.sh /run.sh

RUN chmod +x /run.sh

ENTRYPOINT sh /run.sh

RUN mkdir /work
WORKDIR /work
ADD run.sh /work/run.sh

CMD ["ls", "-l"]

ADD eureka-servier-*.jar eureka-server.jar
CMD ["/bin/bash","./run.sh"]