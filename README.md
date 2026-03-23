# Android Automation Framework

Enterprise-grade Android automation framework originally formulated via the `BLAST.md` protocol to test Android applications (e.g. Jio Cloud). This project employs Appium, Java 16, TestNG, and Maven, with a focus on Page Object Model (POM) and robust element interactions.

## 🚀 Overview

- **Language:** Java 16+
- **Driver:** Appium for Android
- **Testing Framework:** TestNG
- **Build Tool:** Maven
- **Design Pattern:** Page Object Model (POM)
- **Reporting:** ExtentReports (Listener configured)

## 📂 Project Structure

- `src/main/java/com/android/base`: Core configuration and Page/Test base classes.
- `src/main/java/com/android/pages`: Page Objects representing specific app screens (e.g. `AppStartPage`).
- `src/main/java/com/android/utils`: Core utilities such as explicit waits, property readers, and common actions.
- `src/test/java/com/android/tests`: TestNG test suites (e.g., `AppStartTest`, `ConnectionTest`).
- `src/test/resources/config`: Environment configurations (e.g. `config.properties`).

## 🛠 Prerequisites Setup

### 1. Basic Requirements
- **Java**: JDK 16 installed (`JAVA_HOME` configured).
- **Maven**: Installed and added to PATH (`brew install maven`).
- **Android Studio**: For Android SDK, Emulator, and `adb` tools (`ANDROID_HOME` configured).

### 2. Appium Setup
Ensure you install Appium version **8.6.0** (or compatible) for Java 16 alignment.
```bash
npm install -g appium
appium driver install uiautomator2
```

### 3. Emulators & Physical Devices
Make sure a device is visible via `adb`:
```bash
adb devices
```

## 🏃 Execution Guide

### 1. Start Appium Server
Start your local Appium server using the default port (4723) before running any tests.
```bash
appium --port 4723
```

### 2. Configure Test Execution
Update `src/test/resources/config/config.properties` with your specific device and app details (e.g. `appActivity`, `appPackage`, device IDs).

### 3. Run the Test Suite
Execute the tests directly from the root of the project using Maven:
```bash
mvn clean test
```
