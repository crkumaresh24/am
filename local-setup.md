# Run as local ddocker container - Individual Steps
./gradlew clean build
docker build -t platform/auth-manager .
docker stop platform-auth-manager && docker rm platform-auth-manager
docker run -dit --name platform-auth-manager --add-host=host.docker.internal:host-gateway --restart=always -p 9090:8080 -e "MYSQL_HOST=host.docker.internal" -e "MYSQL_USER=root" -e "MYSQL_PASSWORD=mysql" platform/auth-manager

# Run as local ddocker container - Single Command
./gradlew clean build && docker build -t platform/auth-manager . && docker stop platform-auth-manager && docker rm platform-auth-manager && docker run -dit --name platform-auth-manager --add-host=host.docker.internal:host-gateway --restart=always -p 9090:8080 -e "MYSQL_HOST=host.docker.internal" -e "MYSQL_USER=root" -e "MYSQL_PASSWORD=mysql" platform/auth-manager