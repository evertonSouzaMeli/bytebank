FROM gradle:7.4-jdk11 as build

COPY --chown=gradle:gradle . /home/gradle

WORKDIR /home/gradle

RUN gradle build --no-daemon

FROM openjdk:11

RUN mkdir /app

COPY --from=build /home/gradle/build/libs/*.jar /app/docker-sample.jar

ENTRYPOINT ["java","-jar","/app/docker-sample.jar"]