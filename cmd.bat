docker build -t my-spring-app .
docker run -p 8081:8080 -e PORT=8080 my-spring-app