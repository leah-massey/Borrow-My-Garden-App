#take base image from docker hub remote repository
FROM node:23-alpine

#set the working directory
WORKDIR /client/

#COPY . /client
COPY package*.json ./

# Inject the backend URL as an environment variable
ARG VITE_BACKEND_URL
ENV VITE_BACKEND_URL=${VITE_BACKEND_URL}

#Install dependencies
RUN npm install

#copy the rest of the applciation files
COPY . .

EXPOSE 5173

#run the application in development mode
CMD ["npm", "run", "dev"]
