# 🧪 Selenium Test Automation Framework (Java + Maven + TestNG)

This project contains automated UI test scripts built using **Selenium WebDriver**, **Java**, **TestNG**, and **Maven**.  
It supports running tests with different **TestNG suites** and **multiple browsers** using Maven command-line parameters.

---

## 🚀 Features

- ✔️ Java + Selenium WebDriver  
- ✔️ TestNG suite execution (Smoke, Regression, Full)  
- ✔️ Cross-browser support using `-Dbrowser=` argument  
- ✔️ Page Object Model (POM)  
- ✔️ Maven profiles for grouped test execution  
- ✔️ HTML Reports (Extent or Allure — if included)

---

## 📦 Project Structure

src
└── test
├── java
├── resources
└── testng.xml
pom.xml
README.md


---

## ▶️ How to Run the Test Suites

### 🔹 **1. Run Smoke/Regression Suite on Edge**
```sh
mvn test -PSmoke -Dbrowser=edge
mvn test -PRegression -Dbrowser=edge

