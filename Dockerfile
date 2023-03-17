
FROM amazoncorreto:11-alpine-jdk
MAINTAINER Dalmiro Rivero
COPY target/portfolio-0.0.1-SNAPSHOT.jar portfoliodr-app.jar
ENTRYPOINT ["java","-jar","/portfoliodr-app.jar"]

