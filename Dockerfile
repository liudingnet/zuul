FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /app/app.jar
WORKDIR /app/
EXPOSE 8889
ENTRYPOINT ["java","-jar","./app.jar"]


#FROM openjdk:8-jre-alpine
#
#COPY apache-skywalking-apm-incubating /apache-skywalking-apm-incubating
#COPY target/zuul-0.0.1-SNAPSHOT.jar /app.jar
#
#ENTRYPOINT java -javaagent:/apache-skywalking-apm-incubating/agent/skywalking-agent.jar -Dskywalking.collector.backend_service=${SW_AGENT_COLLECTOR_BACKEND_SERVICES} \
#-Dskywalking.agent.application_code=${SW_AGENT_NAME} -jar /app.jar