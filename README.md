# Borrow My Garden

Borrow My Garden is a learning project that is built with a React FE, a Kotlin BE and Postgres DB.
The purpose of this project is to build a functioning application, fully tested using TDD. 

# Table of contents
- [The Concept](#the-concept)
- [Getting Started](#getting-started)

## The Concept

Borrow my Garden is a community project where people can list their unused garden spaces, and keen allotment cultivators can find a space on which to grow their fruit and veg.

The project is inspired by the growing interest in owning an allotment, set against the 10+ year waiting lists for a plot in big cities like London.

The format of the concept is inspired by the popular app ‘Borrow My Doggy’ and also platforms such as AirBnB

Borrow my Garden will be a platform for both aspiring allotmenteers and garden owners to connect and agree on a set-up that works for them.

Once registered a user can:

- list their garden
- edit their garden
- search for a garden
- write a private message to the owner of a garden
- check their past messages 

Typically there would be two users on this platform: 

### I am an aspiring allotmenteer (gardener)

- I want to find a local garden for my allotment
- I am keen to connect with my community
- I am verified by the platform

### I have a garden

- I have space for a veg / I have an existing but unused veg patch
- I don’t have time / desire to grow things and look after the garden
- I may already have tools
- I am keen to connect with my community



## Package
```
./gradlew distZip
```

## Getting started
### Docker Container
To access the BorrowMyGarden database, we need to run a Docker Container:
- Create an account in [Docker](https://login.docker.com/u/login/identifier?state=hKFo2SB1RVBzWTNlZDBRci16alAxNTRTV1Vwckd2Vkczb1AxTaFur3VuaXZlcnNhbC1sb2dpbqN0aWTZIF83Q1ZTRXNBUGUtRWxYLTFpZmlSb2hyeEg3Rk1YcUZro2NpZNkgRmkyQ0VleDZtMzhkS1lxdnZaWVljSms5SUN0cGc3ZzQ)


- Install and start Docker Desktop (you should see the logo in the RH of the browser tab)


- Authenticate your Docker client with a Docker registry:\
```docker login```\
You will be asked to enter your username and password for your Docker account.
You should then see ```Login Succeeded```


- Run the Docker Container:\
```docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=mysecretpassword -d postgres``` \
You should see the new docker container ID

>Troubleshooting : \
```The container name "/some-postgres" is already in use by Container <container_id>```\
Run:\
> ```docker stop <container_name_or_id>```\
```docker rm <container_name_or_id>```\
Now run the docker container again and you should see the new docker container ID

- View list of Docker Containers \
```docker ps```\
You will see your new Container listed here.\
Run again - until you see that status is 'healthy ' or 'up 10 s' - this means the Container is running.\

You now have a Docker Container running with your BorrowMyGarden database

### Start Backend Server
- Ensure gradle installed\
  ```gradle -v```

- build the distribution package (optional)\
** Note: the distribution package does not include test files or dependencies, so you won’t be able to run tests using it.)\
```./gradlew distZip```

- 

#### If using an IDE such as IntelliJ: 

- Navigate to src/main/kotlin/Main.kt and run by clicking the green arrow (Run icon) to start running the backend server.


#### If not using IDE: 


- Navigate to ```src``` directory

- Start the server
```./gradlew run```

** Note Backend server must be started before the Client side server (To start Client side server see client/README.md for instructions)

