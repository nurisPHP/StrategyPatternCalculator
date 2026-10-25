
package kz.nurislam.strategycalculator.context;

import kz.nurislam.strategycalculator.strategy.CalculationStrategy;
import java.util.Objects;

public class Calculator {

    private CalculationStrategy strategy;

    public Calculator(CalculationStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(CalculationStrategy strategy) {
        this.strategy = Objects.requireNonNull(
                strategy,
                "Calculation strategy cannot be null"
        );
    }

    public double calculate(double firstNumber, double secondNumber) {
        return strategy.calculate(firstNumber, secondNumber);
    }
}
