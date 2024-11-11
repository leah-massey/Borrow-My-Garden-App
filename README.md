<a id="readme-top"></a>

<h2 align="center"> 🌷🌿🥕 Borrow My Garden 🥕🌿🌷</h2>
<div align="center">
<p>Borrow My Garden is a learning project that is built with a React FE, a Kotlin BE and Postgres DB.<br>The purpose of this project is to build a functioning application, fully tested using TDD. 
</p>
</div>

___

<h3>Table of contents</h3>

- [About The Project](#about-the-project)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)

___

<!-- ABOUT THE PROJECT -->

<details open>
  <summary>
    <h2 id="about-the-project" style="display: inline; margin: 0;">🪴 About The Project</h2>
  </summary>
  <p>Borrow my Garden is a community project where people can list their unused garden spaces, and keen allotment cultivators can find a space on which to grow their fruit and veg.

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

### I am an aspiring gardener 👨🏽‍🌾

- I want to find a local garden for my allotment
- I am keen to connect with my community
- I am verified by the platform

### I have a garden 🌷

- I have space for a veg / I have an existing but unused veg patch
- I don’t have time / desire to grow things and look after the garden
- I may already have tools
- I am keen to connect with my community</p>

<p align="right">(<a href="#readme-top">back to top</a>)</p>
</details>

___

<details open>
  <summary>
    <h2 id="technologies-used" style="display: inline; margin: 0;">🚀 Technologies Used</h2>
  </summary>
<br>

<h3>Backend</h3>

![Static Badge](https://img.shields.io/badge/Koltin-%23ffcc00?style=for-the-badge&logo=kotlin&logoColor=black)

![Static Badge](https://img.shields.io/badge/Postgresql-%23cc3399?style=for-the-badge&logo=Postgresql&logoColor=black)

![Static Badge](https://img.shields.io/badge/Docker-%23990066?style=for-the-badge&logo=Docker&logoColor=black)

![Static Badge](https://img.shields.io/badge/JUnit-%23ccee66?style=for-the-badge&logo=Junit&logoColor=black)

<h3>Frontend</h3>

![Static Badge](https://img.shields.io/badge/React-%23ff9900?style=for-the-badge&logo=React&logoColor=black)

![Static Badge](https://img.shields.io/badge/Vite-%23ff6600?style=for-the-badge&logo=Vite&logoColor=black)

![Static Badge](https://img.shields.io/badge/Tailwind-%233399cc?style=for-the-badge&logo=Tailwind&logoColor=black)

![Static Badge](https://img.shields.io/badge/Playwright-%23006699?style=for-the-badge&logo=Playwright&logoColor=black)



[//]: # (remaining colour refs: 99cc33, 669900)
<p align="right">(<a href="#readme-top">back to top</a>)</p>
</details>

___

<details open>
  <summary>
    <h2 id="getting-started" style="display: inline; margin: 0;">👩🏼‍💻 Getting Started</h2>
  </summary>

Firstly you will need to create a network for our Docker Containers. 

- Create an account in [Docker](https://login.docker.com/u/login/identifier?state=hKFo2SB1RVBzWTNlZDBRci16alAxNTRTV1Vwckd2Vkczb1AxTaFur3VuaXZlcnNhbC1sb2dpbqN0aWTZIF83Q1ZTRXNBUGUtRWxYLTFpZmlSb2hyeEg3Rk1YcUZro2NpZNkgRmkyQ0VleDZtMzhkS1lxdnZaWVljSms5SUN0cGc3ZzQ)


- Install and start Docker Desktop (you should see the logo in the RH of the browser tab)


- Authenticate your Docker client with a Docker registry:\
  ```docker login```\
  You will be asked to enter your username and password for your Docker account.
  You should then see: ```Login Succeeded```

- Create network for containers: 
```docker network create borrow-my-garden-network```

  <h3>1. Setting Up The Database</h3>
  <p> 
From the root of this app:
Build a Docker container for the Database:

- Run The Docker Container:
  ```shell
  ./scripts/dockerDatabaseBuild.sh
  ```

You should see the new docker container ID

>Troubleshooting : \
```The container name "/borrow-my-garden-db" is already in use by Container <container_id>```\
Run:\
> ```docker stop <container_name_or_id>```\
```docker rm <container_name_or_id>```\
Now run the docker container again and you should see the new docker container ID

- View list of Docker Containers \
  ```docker ps```\
  You will see your new Container listed here.\
  Run again - until you see that status is 'healthy ' or 'up 10 s' - this means the Container is running.

You now have a Docker Container running with your BorrowMyGarden database

### 2. Starting The Backend Server

- Ensure gradle installed\
  ```gradle -v```

- Build the application\
```./gradlew build```

- build the distribution package (optional) ???? \
  ** Note: the distribution package does not include test files or dependencies, so you won’t be able to run tests using it.)\
  ```./gradlew distZip```
 

#### Option 1 - Using Docker:
 Using Docker will set the project up quickly and avoid dependency issues.

- Ensure your Docker App is up and running (see instructions above)

- From the project root, build the Docker image & run the Container based on this image:
  ```shell
  ./scripts/dockerBackendBuild.sh
  ```
  
- You should now see the backend server running on Port 9000 

#### Option 2 - running directly with Gradle :

- From the root of the project

- Start the server
  ```./gradlew run```

** Note Backend server must be started before the Client side server (To start Client side server see client/README.md for instructions)
</p>
<p align="right">(<a href="#readme-top">back to top</a>)</p>
</details>




