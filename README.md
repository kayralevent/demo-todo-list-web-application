//TODO List Web Application

This application has been developed with React and Spring and authenticated with Okta.

Prerequisites: Java 8 and Node.js.

Okta has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage and secure users and roles in any application.

Getting Started
To install this example application, run the following commands:

git clone https://github.com/kayralevent/demo-todo-list-web-application.git
cd demo-todo-list-web-application

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

To run the server; 
- Open project on eclipse, to open project in eclipse, open eclipse and follow the instructions "File->Open Projects from File System". From the opening window click "Directory" and select path of the project's folder. And then click "Finish".
- Install Wampserver to able to use MySQL. Wampserver has an easy-to-use web interface. Wampserver is using 3306 port. Login with root user (username: root, password:(empty)) and create another user (username: admin, password: admin) to match informations in application.properties. (Wampserver download link https://sourceforge.net/projects/wampserver/)
- Run project on eclipse.
- Install JDK, download the jdk for windows from this link, install and configure path settings. (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

To run the client, cd into the client folder and run:

To install Node.js, download the installation file from this link and install. (https://nodejs.org/en/)

npm install && npm start

Now you are ready to go.


Documentation

Controllers;

1. TodoItemController
This controller handles rest api requests from the client for TodoList table.

2. TodoListController
This controller handles rest api requests from the client for TodoItem table.

Models;

1. TodoItem
Entity Table for TodoItems.
Columns: id, name, description, deadLine, status.

2. TodoList
Entity Table for TodoLists.

3. TodoItemRepository
JpaRepository Interface for TodoItem entity table

4. TodoListRepository
JpaRepository Interface for TodoList entity table

With recommendation of Ali Keskin, I used Swagger for testing rest apis.
I need to get use to Java culture.