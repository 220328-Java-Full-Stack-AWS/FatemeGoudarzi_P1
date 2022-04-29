
**Project Specs**
Project 1 - Employee Reimbursment System (ERS)

Executive Summary
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement. The reimbursement types should have the following options: 

**Tech Stack**
Java 8
Apache Maven
PostgreSQL
AWS RDS
Java Servlets
JDBC
HTML
CSS
JavaScript
AJAX / Fetch API

**Functional Requirements**
Domain objects persisted in relational database
Database(Postgresql);
CRUD functionality for all domain objects;
All CRUD functionality accessible via RESTful API;
Functional web UI to consume RESTful API;
Workflows to complete all user stories;
Validate all user input;

The persistence-layer system utilize JDBC to connect to a Postgres database. The API-layer utilize Java servlets to expose a public interface. The front-end view utilizes HTML/CSS/JavaScript to make an application that can call server-side components in a generally RESTful manner. The middle tier follows proper layered architecture. 

**User Stories**
Guest:
As a guest, I can register for a new account
As a guest, I can log into my account
User:
As a user, I can submit a request for reimbursement
As a user, I can cancel a pending request for reimbursement
As a user, I can view my pending and completed past requests for reimbursement
As a user, I can edit my pending requests for reimbursement

Admin/Finance Manager:
As an admin, I can approve expense reimbursements
As an admin, I can deny expense reimbursements
As an admin, I can filter requests by status
Stretch Goals:
As an admin, I can change a user's role between admin and user

