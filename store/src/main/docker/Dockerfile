FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD *.jar store.jar
RUN sh -c 'touch /store.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /store.jar" ]