# RESTful API for Email Scheduling

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green) [![LinkedIn](https://img.shields.io/badge/Connect%20on-LinkedIn-blue)](https://www.linkedin.com/in/gabrieudev) ![GPL License](https://img.shields.io/badge/License-GPL-blue)

Welcome to my **RESTful API for Email Scheduling** project.

Please select your preferred language:

- [English](README.md)
- [Português (Brasil)](README.pt-br.md)

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies](#technologies)
- [Configuration](#configuration)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Contributions](#contributions)
- [Contact](#contact)

## Introduction

The main goal of this project is to provide a RESTful API capable of scheduling email sends. Additionally, it allows you to view, update, or delete these schedules.

## Features

- Email scheduling.
- Updating, deleting, and paginated querying of schedules.
- Integration with MySQL database.
- Documentation using Swagger.

## Technologies

- ![Java](https://img.shields.io/badge/Java-17-orange): Programming language.
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green): Framework used for building applications.
- ![MySQL](https://img.shields.io/badge/MySQL-Database-blue): Relational database.

## Configuration

- Before starting the application, it is necessary to change some variables for JavaMailSender to work. You can do this by navigating to the file: `cd <path>/src/main/resources/application.properties`.

## Getting Started

Follow these steps to run the project on your machine:

1. Clone the repository: `git clone https://github.com/gabrieudev/email-scheduler.git`
2. Navigate to the project directory: `cd <path>`
3. Navigate to the docker directory: `cd docker`
4. Run the docker compose file to create and start the MySQL container: `docker compose up`
5. Return to the initial directory: `cd <path>`
6. Build the project: `./mvnw clean install` (for Windows: `mvnw.cmd clean install`)
7. Run the application: `./mvnw spring-boot:run` (for Windows: `mvnw.cmd spring-boot:run`)

## Endpoints

- `POST /scheduled-emails`: Schedules email sends.
- `GET /scheduled-emails/{scheduledEmailId}`: Gets schedule details by id.
- `GET /scheduled-emails`: Gets details of all schedules.
- `PUT /scheduled-emails/{scheduledEmailId}`: Updates a schedule.
- `DELETE /scheduled-emails/{scheduledEmailId}`: Deletes a schedule.

Access the full documentation at the `/swagger-ui.html` endpoint.

## Contributions

Contributions are very welcome! If you would like to contribute, fork the repository and create a pull request.

## Contact

If you have any suggestions or questions, contact me on [LinkedIn](https://www.linkedin.com/in/gabrieudev).

---

**License:** This project is licensed under the terms of the [GNU General Public License (GPL)](LICENSE).