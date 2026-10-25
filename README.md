# Strategy Pattern Calculator

**Assignment #5 — Strategy Design Pattern**

**University:** Astana IT University  
**Course:** Software Design Patterns  
**Programming Language:** Java 17  
**Build Tool:** Gradle  
**IDE:** IntelliJ IDEA

## 1. Project Overview

This project demonstrates the implementation of the Strategy Design Pattern in Java using a simple calculator.

The calculator supports three mathematical operations: addition, subtraction, and multiplication.

Each operation is implemented as a separate strategy class. The Calculator context can switch between strategies at runtime without using conditional statements to select the operation.

## 2. Strategy Pattern Components

The project includes the following components:

| Component | Description |
|---|---|
| `CalculationStrategy` | Interface that defines the common calculation method |
| `AddStrategy` | Performs addition |
| `SubtractStrategy` | Performs subtraction |
| `MultiplyStrategy` | Performs multiplication |
| `Calculator` | Context that stores and executes the selected strategy |
| `Main` | Client that selects and changes strategies at runtime |

## 3. Project Structure

```text
StrategyPatternCalculator/
├── src/
│   ├── main/java/kz/nurislam/strategycalculator/
│   │   ├── strategy/
│   │   │   ├── CalculationStrategy.java
│   │   │   ├── AddStrategy.java
│   │   │   ├── SubtractStrategy.java
│   │   │   └── MultiplyStrategy.java
│   │   ├── context/
│   │   │   └── Calculator.java
│   │  
