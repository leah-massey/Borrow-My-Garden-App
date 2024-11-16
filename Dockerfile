FROM gradle:8.10.2-jdk21

# Install the PostgreSQL client
RUN apt-get update && apt-get install -y postgresql-client

COPY . /app

WORKDIR /app

ENTRYPOINT ["/app/gradlew", "run"]