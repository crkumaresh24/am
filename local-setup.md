# Prerequestie - MySQL Instal las docker
docker run --name mysql --restart=always -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306 -d mysql

# Run as local ddocker container - Individual Steps
./gradlew clean build
docker build -t platform/auth-manager .
docker stop platform-auth-manager && docker rm platform-auth-manager
docker run -dit --name platform-auth-manager --add-host=host.docker.internal:host-gateway --restart=always -p 9090:8080 -e "MYSQL_HOST=host.docker.internal" -e "MYSQL_USER=root" -e "MYSQL_PASSWORD=mysql" platform/auth-manager

# Run as local ddocker container - Single Command
docker stop platform-auth-manager && docker rm platform-auth-manager
./gradlew clean build && docker build -t platform/auth-manager . && docker run -dit --add-host=host.docker.internal:172.17.0.1 --name platform-auth-manager --restart=always -p 9090:8080 -e "MYSQL_HOST=172.17.0.1" -e "MYSQL_USER=root" -e "MYSQL_PASSWORD=mysql" platform/auth-manager