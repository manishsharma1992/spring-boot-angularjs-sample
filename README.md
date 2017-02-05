# Spring Boot AngularJS 2 Quickstart

## Pre-requisites

JDK 1.8 or later

Maven 3.0+

NodeJS 6 or later

Angular CLI

## Steps to recreate the project

Run `git clone https://github.com/manishsharma1992/spring-boot-angularjs-sample.git` to create the project directory into existing workspace.

Run `npm install -g @angular/cli` to install Angular CLI.

Run `ng init` This command will download node_modules into your workspace.

Run `ng build` to build the project.

Run the database script file `employee-ddl.sql`

Import data file `employee-sample-data.csv`

Before running spring boot, please specify the database properties in `application-[profile].properties`.

```
spring.datasource.username=testdb
spring.datasource.password=testdb
spring.datasource.url=jdbc:mysql://localhost:3306/testdb?useSSL=false
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

Run `mvn spring-boot:run -Dspring.profiles.active=default` if running from command line.
