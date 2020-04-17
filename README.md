# spring-mvc
## Description
This is Sring MVC Web Application that utilizes CRUD operations on sql database in MVC structure.

**note: before you run it please run db schema queries(db.ddl) from resources.
        default login: admin pass: admin.
## Install and Run:
To run this app in eclipse EE:
- `File` -> Open project from file system
- Select the `spring-mvc.zip`
- Right Click on project -> `Run As` -> `Run on Server`.
- It was tested on `apache tomcat 8.5`

## Functionality
This application enables the user to:
- Display all the data in table
- Register new record in database
- Update part of the record
- Delete records
- Look for particular records
- Login page (partial)

## External JAR Used
Can be found in pom.xml

## Developer Notes
### The default database is created in `db.properties` using the  following parameter:

```
driver = com.mysql.cj.jdbc.Driver
url = jdbc:mysql://localhost:3306/employee
db.username = root
db.password = root
```

### Database and table creation(SQL):
In `src/main/resources/db.ddl`




## Feature Completed Since First Iteration

- Added CRUD system in MVC structure
- Styling and formatting
  - added card system for form input
  - added subtle alert system
  - Added Navigation bar
  - Added profile view with pic from profile api.
- Added error handling for invalid input
- Used Maven to create project.
- Added `login` ability.
- added login and user management using `session` and cookies.
- added `filter` to \home route 
- implemented log4j logging.
- changed `filter' to interceptor for session management. 
