# training-JEE-Aperture

## Features

##### Admin panel features
* Scheduling of Code Reviews
* User management
* Mail notification
* Sleek display countdown to next Code Review

##### Technical features
This project is a Dynamic Web Project created with Eclipse.
It uses the MVC model, using jsp pages to display content and servlets to manage the backend.
It makes use of JavaMail, Ajax, Bootstrap etc


##### Bugs and security issues
This project has not been tested against security attacks especially SQL injections.

## Installation
To run this project you will need to set up a MySQL server and link it to your Wildfly server. [See this tutorial](http://www.techpaste.com/2014/05/how-to-configure-datasource-in-jboss-wildfly/)
Link the wildfly db connector with the Web Project in src/META-INF/persistence.xml: set <jta-data-source> with your own data source.
Compile with eclipse and run with Wildfly 10. 
Be sure to include your Oracle JDK, EAR librairies and your server runtime environment in the project buildpath.
You can now access http://localhost:8080/CodeReviewMeeting/dashboard (this URL may vary depending on your configuration)

## Disclaimer 
Tested on Chromium and Chrome v60.
