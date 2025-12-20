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

```
project-root
│── pom.xml
│── README.md
│── .gitignore
│
├── src
│   ├── main
│   │   └── java
│   │       └── org
│   │           ├── AbstractComponents
│   │           ├── PageObjects
│   │           └── resources
│   └── test
│       └── java
│           ├── test
│           └── testComponents
│
├── testNg
│   ├── testNgSmoke.xml
│   ├── testNgRegression.xml
│   └── ParallelTestNG.xml
│
└── target

```



---

## ▶️ How to Run the Test Suites

### 🔹 Browser Options
You can run tests in any supported browser:

```sh
-Dbrowser=chrome
-Dbrowser=edge
-Dbrowser=firefox
```

### 🔹 Run Smoke Suite on Edge
```sh
mvn test -PSmoke -Dbrowser=edge
```
### 🔹 Run Regression Suite on Chrome
```sh
mvn test -PRegression -Dbrowser=chrome
```

