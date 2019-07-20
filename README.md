# Task manager  

Application for managing tasks for a team or a small company  
**Live:** https://task-manager-r.herokuapp.com/  
  
## Features:
Most features require user login  
Not authorized users have access to the welcome screen and login or registration panel
	
Authorized admin or manager can:
-	Create task and assign task to any user
-	View list of all users with possibility to delete user
-	View list of all tasks with editing or deleting task
	
Common user or employee can:
-	Create task only for himself
-	View list of all users with no action allowed
-	View list of all tasks but edit or delete only tasks for which he is responsible 
	
Every authorized user can: 
-	View his own profile
-	Switch task as completed/uncompleted


## Built With
* Spring Boot
* Spring Security
* H2 database
* Maven 
* Thymeleaf
* Bootstrap
* jQuery

## Test users
manager@mail.com, password: 112233  
ann@mail.com, password: 112233  
mark@mail.com, password: 112233
  
  
## Inspiration
https://github.com/sambaf/NHSystem  
https://github.com/springframeworkguru/springbootwebapp  
https://github.com/gustavoponce7/spring-login 