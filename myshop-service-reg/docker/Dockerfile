FROM openjdk:8-jre
MAINTAINER Lusifer <topsale@vip.qq.com>

ENV APP_VERSION 1.0.0-SNAPSHOT
ENV DOCKERIZE_VERSION v0.6.1
ENV SW_VERSION 1.0.0
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

RUN mkdir /app
RUN wget http://192.168.10.146:8081/repository/maven-releases/com/funtl/myshop-external-skywalking/$SW_VERSION/myshop-external-skywalking-$SW_VERSION-6.0.0-Beta.tar.gz \
    && tar -C /app -xzvf myshop-external-skywalking-$SW_VERSION-6.0.0-Beta.tar.gz \
    && rm myshop-external-skywalking-$SW_VERSION-6.0.0-Beta.tar.gz

COPY myshop-service-reg-$APP_VERSION.jar /app/app.jar
ENTRYPOINT ["dockerize", "-timeout", "5m", "-wait", "tcp://192.168.10.150:3306", "java", "-javaagent:/app/skywalking-agent.jar", "-Dskywalking.agent.service_name=myshop-service-reg", "-Dskywalking.collector.backend_service=192.168.10.148:11800", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar", "--spring.profiles.active=prod"]

EXPOSE 9502