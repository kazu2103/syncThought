## Build
FROM gradle:7.1.1-jre11 as builder

COPY . /tmp
WORKDIR /tmp
RUN gradle build -x test

RUN mkdir -p /app
RUN cp -r build/libs/*.jar /app/app.jar

## Run
FROM openjdk:11.0-jre-slim
ENV TZ=Asia/Tokyo

RUN mkdir /app
WORKDIR /app
COPY --from=builder /app/app.jar .
EXPOSE 8080
CMD ["java", "-jar" "/app/app,jar"]
