## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/ERV-JamesDo/todo-list.git
```

**2. Create Mysql database**

```bash
create database todo_app
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/todolist-0.0.1-SNAPSHOT.jar
```
The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/list
    
    POST /api/works
    
    GET /api/works/{id}
    
    PUT /api/works/{id}
    
    DELETE /api/works/{id}

You can test them using postman or any other rest client.
