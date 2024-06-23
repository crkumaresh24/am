# Prerequestie - MySQL Install as docker
docker run --name mysql --restart=always -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 -d mysql

# Run as local ddocker container - Individual Steps
./gradlew clean build
docker build -t platform/am .
docker stop platform-am && docker rm platform-am
docker run -dit --name platform-am --add-host=host.docker.internal:host-gateway --restart=always -p 9090:8080 -e "MYSQL_HOST=host.docker.internal" -e "MYSQL_USER=root" -e "MYSQL_PASSWORD=mysql" platform/am

# Run as local ddocker container - Single Command
docker stop platform-am && docker rm platform-am && ./gradlew clean build && docker build -t platform/am . && docker run -dit --add-host=host.docker.internal:172.17.0.1 --name platform-am --restart=always -p 9090:8080 -e "MYSQL_HOST=172.17.0.1" -e "MYSQL_USER=root" -e "MYSQL_PASSWORD=mysql" platform/am