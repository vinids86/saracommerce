FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD *.jar catalog.jar
RUN sh -c 'touch /catalog.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /catalog.jar" ]