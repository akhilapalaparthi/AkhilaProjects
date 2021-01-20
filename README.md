# Employee Reimbursment System (ERS)

# Description
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

# Features
**Employee**
* Login
* View reimbursement tickets
* Request reimbursement ticket

**Finance Manager**
* Login
* View pending requests
* Approve or deny requests
* Filter requests by status
# Technologies Used

**Backend**
Java - version 1.8.0_271
PostgreSQL - version 42.2.5
Maven - version 2.22.1
JUnit - version 5.4.2
Log4j - version 1.2.17
Tomcat - version 9.0
Javax - version 4.0.1
Jackson - version 2.12.0

**Frontend**
* Bootstrap - version 4.1.1
* HTML
* CSS
* JavaScript

**DevOps / Cloud**
* Docker
* Jenkins
* AWS RDS
* AWS EC2
* AWS S3

**Version Control**
* Git


## Technical Requirements
Technologies Used
Backend
Java - version 1.8.0_271
PostgreSQL - version 42.2.5
Maven - version 2.22.1
JUnit - version 5.4.2
Log4j - version 1.2.17
Tomcat - version 9.0
Javax - version 4.0.1
Jackson - version 2.12.0
Frontend
Bootstrap - version 4.1.1
HTML
CSS
JavaScript
DevOps / Cloud
Docker
Jenkins
AWS RDS
AWS EC2
AWS S3
Version Control
Git
The back-end system shall use JDBC to connect to a Postgres database. The application shall deploy onto a Tomcat Server. The middle tier shall use Servlet technology for dynamic Web application development. The front-end view shall use HTML/CSS/JavaScript to make an application that can call server-side components in a generally RESTful manner. Passwords shall be encrypted in Java and securely stored in the database. The middle tier shall follow proper layered architecture, have reasonable (~70%) test coverage of the service layer, and implement log4j for appropriate logging. Webpages shall be styled to be functional and readable. 

**Stretch Goals:**
* Replace JDBC with Hibernate to manage the database connection.
* Users can upload a document or image of their receipt when submitting reimbursements which can stored in the database and reviewed by a financial manager.
* Postgres Database shall be hosted remotely on an AWS RDS. 
* Java application shall be hosted remotely on an EC2.
* Static files (webpages) shall be hosted on an S3 bucket. 
