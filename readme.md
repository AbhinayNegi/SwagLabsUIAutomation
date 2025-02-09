# SwagLabs UI Automation Framework

This repository contains a scalable and robust automation framework for UI testing of the SwagLabs application. The framework is built using Java, Selenium WebDriver, TestNG, and Maven. It follows industry best practices such as the Page Object Model (POM) and integrates robust logging using SLF4J with Logback.

## Table of Contents

- [Project Overview](#project-overview)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation and Setup](#installation-and-setup)
- [Running Tests](#running-tests)
- [Logging](#logging)
    - [Using Logback](#using-logback)
- [Contributing](#contributing)
- [License](#license)

## Project Overview

This automation framework is designed to:
- **Automate UI Testing:** Utilizing Selenium WebDriver and TestNG.
- **Scale Easily:** With support for multiple browsers (via WebDriverManager) and parallel test execution.
- **Maintain Easily:** Through the Page Object Model (POM) design pattern.
- **Robust Logging:** Integrated logging using SLF4J and Logback to capture detailed logs.

## Project Structure


## Prerequisites

- **Java 11 or higher:** Ensure Java is installed and configured.
- **Maven:** Install Maven for building and running tests.
- **IDE (Optional):** IntelliJ IDEA, Eclipse, or your preferred Java IDE.

## Installation and Setup

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/SwagLabsUIAutomation.git
   cd SwagLabsUIAutomation
   
mvn clean compile

The following commond should be run from terminal from project root to generate the logs
#### mvn -Dlogback.configurationFile="src/main/resources/logback.xml" clean test 

