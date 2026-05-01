FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Install protocol dependency
RUN git clone https://github.com/mariusflores/baby-redis-protocol.git /tmp/protocol \
    && cd /tmp/protocol \
    && mvn install -DskipTests

COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/baby-redis.jar .
EXPOSE 6379
CMD ["java", "-jar", "baby-redis.jar"]