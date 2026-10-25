
package kz.nurislam.strategycalculator.strategy;

public class MultiplyStrategy implements CalculationStrategy {

    @Override
    public double calculate(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }
}
