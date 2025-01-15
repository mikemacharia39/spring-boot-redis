# Spring Boot Redis
This project shows how to work with redis

### Getting Started

* The application shows how to work with Redis
* The application uses docker to run Redis. However, you can install Redis on your local machine.
* Ensure you have installed the below applications:

    |Application|Version|
    |---------|------------|
    |Redis||
    |JDK| \> 11 |
    |Maven| \> 3.0 |

### Overview
The application uses 3 mechanisms to work with Redis:
1. HashOperations
2. ValueOperations
3. JPA - Working with persistence methods

Either of the above will work and usage depends on the context

### Setup

1. git clone https://github.com/mikemacharia39/spring-boot-redis.git

2. mvn clean install package 

### Testing
* Postman Collection
https://www.getpostman.com/collections/3c373b9609b6a280cdc3