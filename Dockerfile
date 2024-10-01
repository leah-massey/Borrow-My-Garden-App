FROM openjdk:11-jre-slim

# The /app directory should act as the main application directory
WORKDIR /app

# Copy the app package and package-lock.json file
COPY package*.json ./

# Copy local directories to the current local directory of our docker image (/app)
COPY ./src ./src

# Copy the JAR file into the container
COPY build/libs/BorrowMyGardenMain.jar app.jar

#RUN ./gradlew build

#EXPOSE 9000

LABEL authors="leahmassey"

#ENTRYPOINT ["top", "-b"] - not sure if needed
ENTRYPOINT ["java", "-jar", "app.jar"]