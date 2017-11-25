FROM openjdk:jre-slim

COPY target/classes /app

RUN echo "exec java -Xmx256m -Xms256m -XX:+AlwaysPreTouch -cp /app test.App" > /app/pretouch.sh &&\
    echo "exec java -Xmx256m -Xms256m -cp /app test.App" > /app/start.sh &&\
    echo "exec java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -cp /app test.App" > /app/cgroup.sh &&\
    chmod 755 /app/*sh

ENTRYPOINT ["/bin/bash"]
