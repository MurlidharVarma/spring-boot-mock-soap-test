# spring-boot-mock-soap-test

A simple project that has following
1. A simple SOAP client
1. A barebone REST API that fetches data from H2 via JPA
1. Junit 5 Test for REST API
1. Junit 5 Test to Mock SOAP response via WireMock

## Usage
1. Clone the git repo
1. Run ```mvn clean install```
1. If you start the Server via ```dev``` profile then
    >* Rest API URL is ```http://localhost:8080/books```
    >* SOAP API URL is ```http://localhost:8080/n2d/39.99``` and ```http://localhost:8080/n2w/2022```
  
