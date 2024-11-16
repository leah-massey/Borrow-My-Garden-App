docker build -t borrow-my-garden-backend  .

docker run \
  --network borrow-my-garden-network \
  --name borrow-my-garden-backend-container \
  -p 9000:9000 \
  -e DB_HOST=borrow-my-garden-db \
  -e DB_PORT=5432 \
  -e DB_NAME=borrowmygarden \
  -e DB_USER=postgres \
  -e DB_PASSWORD=mysecretpassword \
  borrow-my-garden-backend