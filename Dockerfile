FROM gradle:8.10.2-jdk21

COPY . /app

WORKDIR /app

ENTRYPOINT ["/app/gradlew", "run"]