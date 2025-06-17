
# 🍽️ Online Food Delivery Application

This is a full-stack web application that enables users to register, login, browse restaurants, and place orders from various food outlets.

## 🚀 Features

- User Registration & Login with Session Management
- Role-based Access (Customer, Restaurant Owner, Admin)
- Restaurant Listings with Images and Details
- Dynamic Menus and Item Browsing
- Responsive UI with Modals for Login/Register
- Pop-up messages for success/error feedback

## 💻 Technologies Used

### Backend:
- Java (JSP, Servlets)
- JDBC for database connectivity
- MySQL for persistent data storage

### Frontend:
- HTML, CSS, JavaScript
- JSP for dynamic UI rendering

### Tools:
- Eclipse IDE
- Apache Tomcat Server
- Git & GitHub for version control

## 📁 Project Structure


OnlineFoodApp/
├── src/
│ └── com.project/
│ ├── model/
│ ├── DAO/
│ ├── DAOImpl/
│ └── servlet/
├── WebContent/
│ ├── home.jsp
│ ├── styles.css
│ └── images/
├── .classpath
├── .project
└── .settings/


## 🧑‍💻 Developed By

This project was developed by **Basappagari Mukesh** as part of a full-stack training program at **TAP Academy**, where I gained hands-on experience with real-world applications using Java and web technologies.
---



▶️ How to Run the Project
Clone the Repository

bash
Copy
Edit
git clone https://github.com/your-username/online-food-delivery-application.git
Open in Eclipse

Open Eclipse IDE

Go to File → Import → Existing Projects into Workspace

Select the project folder you just cloned

Click Finish

Set Up the Database (MySQL)

Create a new database in MySQL (e.g., foodappdb)

Import the SQL script (if available) or create tables manually based on your DAO logic

Update your DB connection details in the UserDAOImpl and other DAO files

Run the Project

Right-click the project → Run As → Run on Server

Choose Apache Tomcat Server

The project will launch in your browser (e.g., http://localhost:8080/OnlineFoodApp/first)



