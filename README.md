# Notification System

## Overview
This project is a notification system designed to filter tax schedules from a database based on a specific date range and send personalized email notifications using an SMTP server. 
The email content is dynamically generated using the Thymeleaf template engine.

## Features
•	Filter Tax Schedules:
•	Retrieve records from the database based on a specified startDate and endDate.
•	Both startDate and endDate are mandatory and can be the same.
•	Dynamic Email Templates:
•	Use Thymeleaf templates stored in the resources/templates/ directory to generate email content dynamically.
•	Populate email templates with attributes retrieved from the database.
•	SMTP Email Sending:
•	Send rendered HTML emails to a list of recipient email addresses using an SMTP server.
•	Emails are sent sequentially to each recipient.

## Technologies Used
•	Backend Framework: Spring Boot 3.4.1
•	Programming Language: Java (JDK 21)
•	Database: PostgreSQL
•	Template Engine: Thymeleaf
•	Email Sending: Spring Boot Mail (JavaMailSender)
•	Build Tool: Gradle
•	Testing Framework: JUnit 5, Mockito

## Prerequisites
•	JDK 21 installed.
•	PostgreSQL database set up and running.
•	SMTP server credentials (e.g., Gmail, AWS SES, etc.).
