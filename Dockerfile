FROM alpine-jdk:base
MAINTAINER wgmartinez
COPY target/greeting-app-backend-0.0.1-SNAPSHOT.jar /opt/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/lib/greeting-app-backend-0.0.1-SNAPSHOT.jar", "--server.port", "9090"]
EXPOSE 9090
