
package kz.nurislam.strategycalculator.client;

import kz.nurislam.strategycalculator.context.Calculator;
import kz.nurislam.strategycalculator.strategy.AddStrategy;
import kz.nurislam.strategycalculator.strategy.SubtractStrategy;
import kz.nurislam.strategycalculator.strategy.MultiplyStrategy;

public class Main {

    public static void main(String[] args) {

        double firstNumber = 10;
        double secondNumber = 5;

        Calculator calculator = new Calculator(new AddStrategy());

        System.out.println("=== Strategy Pattern Calculator ===");

        System.out.println("Addition: " +
                calculator.calculate(firstNumber, secondNumber));

        calculator.setStrategy(new SubtractStrategy());

        System.out.println("Subtraction: " +
                calculator.calculate(firstNumber, secondNumber));

        calculator.setStrategy(new MultiplyStrategy());

        System.out.println("Multiplication: " +
                calculator.calculate(firstNumber, secondNumber));
    }
}
