FROM gradle:7.4-jdk11 as build

COPY --chown=gradle:gradle ./ /home/gradle

WORKDIR /home/gradle

RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine

RUN mkdir /app

COPY --from=build /home/gradle/build/libs/*.jar /app/docker-sample.jar

ENTRYPOINT ["java","-jar","/app/docker-sample.jar"]