# Requirements
* Docker
* Maven

# Building Project

From the root directory of the project: 

Run `mvn clean install` - This builds the modules and the docker images.

# Running Project

Run `docker run -p 9090:9090 com.pgse/grpc-spring/grpc-spring-server:1.0-SNAPSHOT` - Starts the gRPC server.

Run `docker run com.pgse/grpc-spring/grpc-spring-client:1.0-SNAPSHOT` - Starts the gRPC client.