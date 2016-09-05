#基础镜像添加jdk 1.8
FROM java:8

#使用端口号
EXPOSE 8871

#添加run.sh文件到根目录
ADD run.sh /run.sh

#增加run.sh文件的运行权限
RUN chmod +x /run.sh

#添加jar文件到根目录
ADD car-cash.jar /car-cash.jar

#运行run.sh脚本文件
ENTRYPOINT sh /run.sh