#//TODO List Web Application

This application has been developed with React and Spring and authenticated with Okta.

Prerequisites: Java 8 and Node.js.

Okta has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage and secure users and roles in any application.

Getting Started
To install this example application, run the following commands:

git clone https://github.com/kayralevent/demo-todo-list-web-application.git
cd demo-todo-list-web-application

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

To run the server; 
- open project on eclipse
- install wampserver login with root user (username: root, password:(empty)) and create another user (username: admin, password: admin) to match informations in application.properties.
- run project on eclipse.

To run the client, cd into the client folder and run:

npm install && npm start

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