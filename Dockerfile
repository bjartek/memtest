FROM openjdk:9-jre

COPY target/classes /app

RUN echo "exec java -Xmx256m -Xms256m -XX:+AlwaysPreTouch -cp /app test.App" > /app/pretouch.sh &&\
    echo "exec java -Xmx256m -Xms256m -cp /app test.App" > /app/start.sh &&\
    chmod 755 /app/*sh

ENTRYPOINT ["/bin/bash"]