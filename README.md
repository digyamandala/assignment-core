# assignment-core
Product Assignment

To run the project, you much specify the datasource url, username, and password in the application properties.
Here is the _**sample**_ below.
```agsl
spring.datasource.url=jdbc:postgresql://localhost:5432/govtech_procurement
spring.datasource.username=root
spring.datasource.password=root
```
Once you have set the data source appropriately, you will be able to run the java application using IntellJ IDEA (or any text editor)
or you can run it by using this command inside this repository
```agsl
mvn clean install && java -jar target/assignment-core-0.0.1-SNAPSHOT.jar 
```

After the application is successfully run, you will be able to access the API Documentation using swagger with this path below
from your local.
```agsl
http://localhost:8080/docs
```