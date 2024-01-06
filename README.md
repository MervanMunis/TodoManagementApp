# <div align="center" style="color:#1976D2">Todo List Management Spring Boot3 Backend Project</div>

### Table of Contents
- [Introduction](#introduction)
- [API Overview](#api-overview)
  - [RESTful API](#restful-api)
- [Architecture of API](#architecture-of-api)
- [Spring Framework](#spring-framework)
- [Importance and Usage of Spring Boot 3.0](#importance-and-usage-of-spring-boot-30)
  - [Rapid Development](#rapid-development)
  - [Microservices](#microservices)
  - [Opinionated Defaults](#opinionated-defaults)
  - [Embedded Servers](#embedded-servers)
  - [Spring Ecosystem Integration](#spring-ecosystem-integration)
- [How to Initialize a Spring Project](#how-to-initialize-a-spring-project)
- [Step by Step Preparing The Spring Project](#step-by-step-preparing-the-spring-project)
  - [Entity Folder](#entity-folder)
  - [Dto Folder](#dto-folder)
  - [Repository Folder](#repository-folder)
  - [Service Folder](#service-folder)
  - [Controller Folder](#controller-folder)
  - [Exception Folder](#exception-folder)
- [Authentication](#authentication)
  - [Authentication Types](#authentication-types)
  - [Basic Authentication](#basic-authentication)
  - [Security of The Project](#security-of-the-project)
- [Integrating The project Into React](#integrating-the-project-into-react)
- [Edditions](#Editions)
- [Future Works](#future-works)

#### Introduction:
Think of your to-do list as a team effort, a musical collaboration! You, the user, call the shots—decide if tasks are done. Then, there's the admin, managing tasks, adding or updating. When you both play your parts, the to-do list becomes a success story. So, let's make a java maven project!

#### API Overview:
An API (Application Programming Interface) is a set of rules that allows different software applications to communicate with each other. APIs, or Application Programming Interfaces, are like digital bridges that let different software systems talk to each other. They come in various types, like Web APIs for web development, Library APIs for reusable code, Hardware APIs for interacting with hardware, and OS APIs for utilizing operating system features. Essentially, APIs make it possible for diverse applications to work together and share functionalities, enhancing the overall capabilities of software. 

#### RESTful API: 
RESTful APIs, or Representational State Transfer APIs, are a popular type of web API. They use standard HTTP methods like GET, POST, PUT/PATCH, and DELETE for operations. RESTful APIs are designed to be simple, scalable, and stateless. They often communicate using JSON format and follow a client-server architecture, allowing different applications to interact seamlessly over the web. This simplicity and flexibility make RESTful APIs a go-to choice for many web developers building scalable and interconnected systems. Todo-Management follows REST principles to ensure a stateless, scalable, and standardized approach to communication between the backend and frontend.

#### Architecture of API:
Spring Boot Application Architecture

![Architecture Diagram](https://github.com/MervanMunis/TodoManagementApp/blob/master/Spring-Boot-Application-Architecture.png)

#### Spring Framework:
The Todo-Management Backend is built on the Spring Framework, a powerful and widely used framework for Java-based applications. Spring provides comprehensive infrastructure support, making it easier to build robust and scalable applications.

#### Importance and Usage of Spring Boot 3.0:
Spring Boot is a project within the Spring Framework that simplifies the process of building production-ready applications with minimal configuration. Todo-Management utilizes Spring Boot 3.0, taking advantage of its enhanced features and optimizations.

##### Rapid Development: 
Spring Boot accelerates development by providing default configurations and eliminating the need for a lot of manual setup. Developers can get started quickly with minimal effort.

##### Microservices: 
It's widely used in microservices architecture due to its modular and lightweight nature. Each microservice can be a standalone Spring Boot application.

##### Opinionated Defaults: 
Spring Boot comes with sensible defaults for many configurations, reducing the need for developers to make decisions on every aspect. This opinionated approach helps maintain consistency across projects.

##### Embedded Servers: 
It includes embedded servers like Tomcat, Jetty, or Undertow, making it easy to package applications as standalone JARs, eliminating the need for an external web server.

##### Spring Ecosystem Integration: 
Spring Boot seamlessly integrates with other projects in the Spring ecosystem, like Spring Data, Spring Security, and Spring Cloud.  şunu madde madde yazmanı istiyorum 1. 2. şeklinde README.md ye göre
 
#### How to Initialize a Spring Project:
You can initialize your spring project by using Spring Initializer: https://start.spring.io/

![Spring Initilizer](https://github.com/MervanMunis/TodoManagementApp/blob/master/Spring-Initilizer.png)

#### Step by Step Preparing The Spring Project:

To initiate the Spring project, we start by generating a Maven project using the Spring Initializer. Lombok is employed to simplify code structure by automating the creation of getters, setters, and constructors.

Following project creation, we create a Java class named "Todo" to serve as the entity. Lombok's features streamline this process, minimizing boilerplate code and enhancing code clarity.

This approach prioritizes efficiency and readability, providing a solid foundation for subsequent development stages.

##### Entity Folder:
In this project, the Todo entity is established and connected to the MySQL database using annotations such as @Entity and @Table. Essential annotations like @Id, @GeneratedValue(strategy = GenerationType.IDENTITY), and @Column are employed to define the column structure within the Todo table.

##### Dto Folder:
To safeguard sensitive database information, a direct connection to the Todo entity is avoided. Instead, a dedicated Dto (Data Transfer Object) folder is created. Within this folder, a Java file named TodoDto mirrors the parameters of the Todo entity.

Unlike a previous project where a dedicated mapper folder was manually crafted to facilitate the mapping of information between Todo and TodoDto, this project leverages the ModelMapper library. This library streamlines the mapping process between the Todo and TodoDto entities.

##### Repository Folder:
To interact with the MySQL database and execute CRUD (Create, Read, Update, Delete) operations, a TodoRepository interface is established in the repository folder. JpaRepository implementation is employed for simplified SQL query management. By merely implementing JpaRepository, database interactions become more straightforward.

##### Service Folder:
To encapsulate the business logic and handle CRUD operations, an ITodoService interface is introduced in the service folder. A concrete implementation, TodoServiceImpl, is created in the service/impl folder. TodoServiceImpl not only implements ITodoService but also utilizes the Repository class and TodoDto class for performing CRUD operations. Method overriding is applied for a systematic approach, and the ModelMapper library facilitates seamless data mapping.

The service layer, crucial for business logic, is annotated with @Service to ensure compatibility with the Spring Framework.

##### Controller Folder:
A TodoController is then crafted in the controller folder to handle HTTP requests and invoke methods from TodoServiceImpl. This class is annotated with @RestController, signifying its role in processing HTTP requests. Annotations such as @RequestMapping, @PostMapping, @PutMapping, @GetMapping, @PatchMapping, and @DeleteMapping are employed for specifying the type of HTTP requests. Additionally, @RequestBody and @PathVariable annotations are utilized for handling request bodies and path variables, respectively.

##### Exception Folder:
To manage exceptions, an exception folder is introduced, housing Java classes specifically designed for exception handling. This ensures robust error management within the application.

#### Authentication:
Authentication in the Spring Framework is the process of verifying the identity of a user or system. It ensures that the entities interacting with an application are who they claim to be. Spring provides various authentication mechanisms to cater to different security requirements. Here are some types of authentication in the Spring Framework:

##### Authentication Types:
There are many types of authentication such as Basic Authentication, Memory Authentication, JWT (JSON Web Token) Authentication, OAuth 2.0 Authentication, LDAP (Lightweight Directory Access Protocol) Authentication, and Custom Authentication Providers. In this Basic authentication is used. Each authentication type has its advantages and use cases. The choice depends on factors such as the application's security requirements, scalability, and the existing infrastructure. Combining multiple authentication mechanisms or using them in conjunction with authorization mechanisms like Spring Security can provide a comprehensive security solution for Spring-based applications.

##### Basic Authentication:
Explanation: Basic Authentication involves sending a username and password with each request. The credentials are typically Base64-encoded and included in the HTTP header. It is a simple yet widely used method, but it lacks security when used without additional measures such as HTTPS.

##### Security of The Project:
In the Entity folder, the User table acts as a repository for crucial user information, facilitating seamless registration and login transactions. The Dto folder introduces LoginDto and RegisterDto for mapping data to and from the User table—RegisterDto for user registration and LoginDto for handling login information, including admin and user roles.

In the Service folder, business methods handle user registration and login, utilizing a repository for smooth database interactions. The Controller folder uses the @PostMapping annotation to seamlessly integrate these authentication functionalities into the application.

The Security folder enhances the security layer with CustomUserDetailsService, invoked by Spring Security to load user details. The returned UserDetails object encapsulates vital user information.

The Configuration folder is pivotal for security measures, implementing basic authentication and intentionally disabling CSRF protection. Annotations like @EnableMethodSecurity, @Configuration, and @Bean in the configuration file play essential roles in shaping the overall security configuration.

@EnableMethodSecurity:
Definition: Enables method-level security, allowing fine-grained control over access to specific methods.

@Configuration:
Definition: Marks a class as a configuration class, indicating it contains methods to configure security settings.

@Bean:
Definition: Declares a bean, used to define and customize instances of classes, including security-related components.
These annotations collectively contribute to a robust security configuration, ensuring effective authentication mechanisms.

#### Integrating The project Into React:

This project is seamlessly integrated with a React project. The React DOM communicates with the backend Spring Boot through the axios library. An illustrative example is provided below for clarity.

```javascript
import axios from "axios";

export const getAllTodos = () => axios.get(BASE_REST_API_URL)

export const saveTodo = (todo) => axios.post(BASE_REST_API_URL, todo)

export const getTodo = (id) => axios.get(BASE_REST_API_URL + '/' + id)
```

#### Editions:


#### Future Works:
In the future, I plan to evolve this project into a microservices architecture. The transformation will involve breaking down the existing monolithic structure into smaller, independently deployable services. Following this, I aim to dockerize the project, encapsulating each service into containers for enhanced portability and scalability. The orchestration of these containers will be managed using Kubernetes, providing a robust and efficient framework for deployment, scaling, and maintenance in a containerized environment. This forward-looking approach will not only improve the project's flexibility and resilience but also align it with modern best practices in software development and deployment.

##### To visualize the microservices and Docker:

![Microservice Architecture](https://github.com/MervanMunis/TodoManagementApp/blob/master/Microservice-Architecture.png)


![Docker](https://github.com/MervanMunis/TodoManagementApp/blob/master/Container-Engine.png)

Thank You For the Greate Tutorials ![Ramesh Fadatare](https://github.com/RameshMF)
