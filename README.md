## Employee Reimbursement System (ERS)

## Project Description
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time.System admin is the only person can make an account for new employees and register them in the system. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement. There are 3 roles in the system: Admin, Financial Manager and regular user(user). 

Admin:
- As an admin, I can log into my account
- As an admin, I can create an account for new employees.

Financial manager:
- As an Financial, I can approve expense reimbursements
- As an Financial, I can deny expense reimbursements
- As an Financial, I can filter requests by status

Regular user:
- As a user, I can log into my account
- As a user, I can submit a request for reimbursement
- As a user, I can cancel a pending request for reimbursement
- As a user, I can view my pending and completed past requests for reimbursement
- As a user, I can edit my pending requests for reimbursement

## Technologies Used
- Java 8
- Java Servlets
- JDBC
- PostgreSQL
- AWS RDS
- JavaScript
- AJAX / Fetch API
- Apache Maven
- HTML
- CSS

## Features :

Usable features now:
- Register a new account
- login
- logout
- Create new a reimbursement.
- Delete or edit a reimbursement if it is not approved.
- Access to reimbursement reports.
- Restricted access for reimbursements approval or denial. (Only financial manager can approve or deny a reimbursement)
-Restricted access for account creation. (Only system admin can make an account.)

To-do list:
- Password hashing;
- Account management;
