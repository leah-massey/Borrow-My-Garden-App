docker build -t borrow-my-garden-backend  .

docker run -p 9000:9000 --network borrow-my-garden-network borrow-my-garden-backend
