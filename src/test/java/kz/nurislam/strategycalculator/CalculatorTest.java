
package kz.nurislam.strategycalculator;

import kz.nurislam.strategycalculator.context.Calculator;
import kz.nurislam.strategycalculator.strategy.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAddTwoNumbers() {
        Calculator calculator = new Calculator(new AddStrategy());

        double result = calculator.calculate(10, 5);

        assertEquals(15.0, result);
    }

    @Test
    void shouldSubtractTwoNumbers() {
        Calculator calculator = new Calculator(new SubtractStrategy());

        double result = calculator.calculate(10, 5);

        assertEquals(5.0, result);
    }

    @Test
    void shouldMultiplyTwoNumbers() {
        Calculator calculator = new Calculator(new MultiplyStrategy());

        double result = calculator.calculate(10, 5);

        assertEquals(50.0, result);
    }

    @Test
    void shouldSwitchStrategyAtRuntime() {
        Calculator calculator = new Calculator(new AddStrategy());

        assertEquals(15.0, calculator.calculate(10, 5));

        calculator.setStrategy(new MultiplyStrategy());

        assertEquals(50.0, calculator.calculate(10, 5));
    }

    @Test
    void shouldRejectNullStrategy() {
        assertThrows(NullPointerException.class,
                () -> new Calculator(null));
    }
}
