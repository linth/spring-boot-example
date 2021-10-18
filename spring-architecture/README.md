# Developing with Spring Boot
## Structuring Your Code

```
com
 +- example
     +- myapplication
         +- MyApplication.java
         |
         +- customer
         |   +- Customer.java
         |   +- CustomerController.java
         |   +- CustomerService.java
         |   +- CustomerRepository.java
         |
         +- order
             +- Order.java
             +- OrderController.java
             +- OrderService.java
             +- OrderRepository.java
```

## another recommendation structure

```
config - class which will read from property files
cache - caching mechanism class files
constants - constant defined class
controller - controller class
exception - exception class
model - pojos classes will be present
security - security classes
service - Impl classes
util - utility classes
validation - validators classes
bootloader - main class
```

```
dao - data access object
dto - data transform object
```


## Reference
- [Developing with Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.structuring-your-code)
- [What is the recommended project structure for spring boot rest projects?](https://stackoverflow.com/questions/40902280/what-is-the-recommended-project-structure-for-spring-boot-rest-projects)