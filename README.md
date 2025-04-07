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

‼ Note, when following the below steps, I have noticed a short delay before the front end is available / working in the browser. If you expereince this, please wait a minute and refresh!

1. Clone this repository

2. Build the application\
  ```./gradlew build```

3. Spin up application (see 2 options below)

<h3> Option 1 - Using Docker:</h3>
Using Docker to spin up this application will set the project up quickly and avoid dependency issues.

Firstly you will need to create a network for the Docker Containers. 

- Create an account in [Docker](https://login.docker.com/u/login/identifier?state=hKFo2SB1RVBzWTNlZDBRci16alAxNTRTV1Vwckd2Vkczb1AxTaFur3VuaXZlcnNhbC1sb2dpbqN0aWTZIF83Q1ZTRXNBUGUtRWxYLTFpZmlSb2hyeEg3Rk1YcUZro2NpZNkgRmkyQ0VleDZtMzhkS1lxdnZaWVljSms5SUN0cGc3ZzQ)


- Install and start Docker Desktop


- Authenticate your Docker client with a Docker registry in the terminal:\
  ```docker login```\
  You might be asked to enter your username and password for your Docker account.
  You should then see: ```Login Succeeded```

<h4>Setting Up The Docker Containers</h3>
  <p> 
Build the images and start running the containers for the following:

- Borrow My Garden Database
- Borrow My Garden Backend
- Borrow My Garden Frontend

This can be done by running the following command from the root of the application which reads the `docker-compose.yml`.

  ```shell
  docker compose up -d 
  ```


- To view list of Docker Containers : ```docker ps```\
  You will see your new Containers listed here with their respective status' and the ports that they are running on.


- You can now navigate to http://localhost:5173/gardens to view this application in the browser. 

  

#### Option 2 - running directly with Gradle :

- Start the backend server from the root of the application:

  ```./gradlew run```


- Start the client side server:

  Open a new terminal in the IDE. From here, follow the instructions in `client/README.md` to get the client side server up and running and to view the application the browser.

** Note Backend server must be started before the Client side server 
</p>
<p align="right">(<a href="#readme-top">back to top</a>)</p>
</details>




