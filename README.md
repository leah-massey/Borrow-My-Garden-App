# BorrowMyGardenMain

Borrow My Garden is a learning project that will be built with a React FE, a Kotlin BE and Postgres DB.
The purpose of this project is to build a functioning application, fully tested using TDD. 

## The concept

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

To run this app you will need to first start the backend server and then the frontend server, in separate terminals. 

Backend server:  navigate to `Main.kt` and click the green arrow to the left of the Main function. You should see in the run tab the message Server started on 9000

Frontend server: navigate to the client directory and run `pnpm dev` from the terminal. You will see the following link appear: Local:   http://localhost:5173/
follow the link to see the app in your browser.


to run the docker container:
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres

