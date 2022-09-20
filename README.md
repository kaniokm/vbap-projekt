# Football team database backend

Spring Boot backend for football team database using MySQL database. API secured by JWT token.
You will need MySQL database for this to run. You can make one in docker with "docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw  -p 3306:3306 -dmysql:latest" and then make empty database with name "vbap" or change the name in properties.

Architecture:
![image](https://user-images.githubusercontent.com/79103806/188279502-0baf7777-5dbc-43fd-90c7-92a59b25ba86.png)

E-R Diagram:
![entityManagerFactory(EntityManagerFactoryBuilder)](https://user-images.githubusercontent.com/79103806/189956155-86cb6ad0-9e87-46a1-a635-a52cab2be99a.png)
