FROM java:8

MAINTAINER zslin.com "zsl131@hotmail.com"

#安装maven
RUN mkdir /var/tmp/maven
RUN wget -P /var/tmp/maven http://mirrors.cnnic.cn/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
RUN tar xzf /var/tmp/maven/apache-maven-3.3.9-bin.tar.gz -C /var/tmp/maven
RUN rm -rf /var/tmp/maven/apache-maven-3.3.9-bin.tar.gz

#设置maven环境变量
ENV MAVEN_HOME=/var/tmp/maven/apache-maven-3.3.9
ENV PATH=$MAVEN_HOME/bin:$PATH

#打包示例项目
RUN mkdir /var/tmp/webapp

ADD ./ /var/tmp/webapp


RUN cd /var/tmp/webapp && mvn package && cp /var/tmp/webapp/target/*.jar /

ENTRYPOINT ["ll", "target"]

ENTRYPOINT ["java", "-jar", "*.jar"]

EXPOSE 8762


#https://segmentfault.com/a/1190000002895521