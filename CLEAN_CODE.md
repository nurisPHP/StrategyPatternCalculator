# Clean Code Principles — Strategy Pattern Calculator

## 1. Elimination of Conditional Logic

**Principle:** Replace complex conditional statements with polymorphism.

**Before (without Strategy Pattern):**

```java
if (operation.equals("add")) {
    return a + b;
} else if (operation.equals("subtract")) {
    return a - b;
} else if (operation.equals("multiply")) {
    return a * b;
}
```

**After (with Strategy Pattern):**

```java
public double calculate(double firstNumber, double secondNumber) {
    return strategy.calculate(firstNumber, secondNumber);
}
```

**Explanation:**

The Calculator class does not use if/else or switch statements to select an algorithm. Instead, it delegates the calculation to the selected strategy using polymorphism. This makes the code easier to maintain.

## 2. Meaningful and Intention-Revealing Names

**Principle:** Use clear names that describe the purpose of classes and methods.

**Before (unclear names):**

```java
class A {
    double calc(double x, double y) {
        return x + y;
    }
}
```

**After (our implementation):**

```java
public class AddStrategy implements CalculationStrategy {

    @Override
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
```

**Explanation:**

Names such as AddStrategy, SubtractStrategy, MultiplyStrategy, and CalculationStrategy clearly describe their responsibilities. The method name calculate() also explains its purpose.

## 3. Single Responsibility Principle (SRP)

**Principle:** Each class should have one main responsibility.

**Before (multiple responsibilities):**

```java
class Calculator {
    double add(double a, double b) {
        return a + b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    double multiply(double a, double b) {
        return a * b;
    }
}
```

**After (our implementation):**

```java
public class MultiplyStrategy implements CalculationStrategy {

    @Override
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}
```

**Explanation:**

Each concrete strategy is responsible for only one mathematical operation. The Calculator class is responsible for managing and executing the selected strategy. This separation makes the system easier to understand, test, and maintain.

## 4. Algorithm-Agnostic Context

**Principle:** The Context should not depend on the internal implementation of concrete strategies.

**Annotated code from Calculator.java:**

```java
private CalculationStrategy strategy;

public void setStrategy(CalculationStrategy strategy) {
    this.strategy = Objects.requireNonNull(
            strategy,
            "Calculation strategy cannot be null"
    );
}

public double calculate(double firstNumber, double secondNumber) {
    return strategy.calculate(firstNumber, secondNumber);
}
```

**Explanation:**

The Calculator class depends on the CalculationStrategy interface rather than concrete strategy classes. It does not need to know how addition, subtraction, or multiplication is performed.

The strategy is provided through the constructor and can be changed using setStrategy(). This demonstrates dependency injection and runtime flexibility.

## 5. Open/Closed Principle (OCP)

**Principle:** Software classes should be open for extension but closed for modification.

**Existing implementation:**

```java
public interface CalculationStrategy {
    double calculate(double firstNumber, double secondNumber);
}
```

**Example of a possible new strategy:**

```java
public class DivideStrategy implements CalculationStrategy {

    @Override
    public double calculate(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return firstNumber / secondNumber;
    }
}
```

**Explanation:**

We can add DivideStrategy without modifying the existing Calculator class or the CalculationStrategy interface.

The client can use the new strategy through setStrategy(). This demonstrates that the system is easy to extend.

The DivideStrategy code is an example of a future extension and is not part of the current implementation.

## Conclusion

The Strategy Pattern Calculator demonstrates five Clean Code principles: elimination of conditional logic, meaningful naming, single responsibility, algorithm-independent context, and open/closed design.

These principles make the application more flexible, readable, testable, and maintainable. Although the Strategy Pattern introduces additional classes, each class has a clear responsibility.

The project also includes five JUnit tests to verify mathematical operations, runtime strategy switching, and null-strategy validation.
