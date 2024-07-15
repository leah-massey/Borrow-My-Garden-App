FROM openjdk:11-jre-slim

# The /app directory should act as the main application directory
WORKDIR /app

# Copy the app package and package-lock.json file
COPY package*.json ./


# Copy local directories to the current local directory of our docker image (/app)
COPY ./src ./src
COPY ./public ./public

# Copy the JAR file into the container
COPY build/libs/BorrowMyGardenMain.jar app.jar

LABEL authors="leahmassey"

ENTRYPOINT ["top", "-b"]