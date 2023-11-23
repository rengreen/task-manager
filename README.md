# Task manager  

Application for managing tasks for a team or a small company  
  
## Features:
Most features require logging in   
Not authorized users have access to the welcome screen and login or registration panel
	
**Admin (manager) can:**
-	Create task and assign task to any user
-	View list of all users with possibility to delete user
-	View list of all tasks with editing or deleting task
-	Switch task as completed/uncompleted
	
**Common user (employee) can:**
-	Create task only for himself
-	View list of all users with no action allowed
-	View list of all tasks but edit or delete only tasks for which he is responsible 
-	Switch owned task as completed/uncompleted
	
**Every authorized user can:** 
-	View his own profile


## Built With
* Spring Boot
* Spring Security
* H2 database
* Maven 
* Thymeleaf
* Bootstrap
* jQuery

## Test users
Paste email and password into the login form or click one of demo buttons under the login form to quickly insert them:  

`manager@mail.com`  password: `112233`  
`ann@mail.com`  password: `112233`  
`mark@mail.com`  password: `112233`
  
  
## Inspiration
https://github.com/sambaf/NHSystem  
https://github.com/springframeworkguru/springbootwebapp  
https://github.com/gustavoponce7/spring-login 
