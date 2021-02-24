Welcome to GitHubApi. It's an app for getting specific user data from the "users" api of GitHub

To use this app, call the endpoint http://localhost:8080/users/<userlogin> . You can do it even on your browser.

To see the records of the database, go to http://localhost:8080/h2-console
and use the following settings:
Setting Name: Generic H2 (Embedded)
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: password

Then select the "REQUEST_INFO" table and click "Run"