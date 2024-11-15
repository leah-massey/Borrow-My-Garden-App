# pull latest postgres image
docker pull postgres

# create database container
docker run --name borrow-my-garden-db --network borrow-my-garden-network -p 6543:5432 -v borrow-my-garden-data:/var/lib/postgresql/data -e POSTGRES_PASSWORD=mysecretpassword -d postgres

