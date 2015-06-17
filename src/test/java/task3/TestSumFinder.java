package task3;

import com.mr_faton.task3.core.SumFinder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestSumFinder {
    @Test
    public void testSM() {
        List<Integer> numbers = new ArrayList<>(5);
        numbers.add(4);
        numbers.add(6);
        numbers.add(10);
        numbers.add(100);

        List<Integer> correctAswers = new ArrayList<>(5);
        correctAswers.add(6);
        correctAswers.add(9);
        correctAswers.add(27);
        correctAswers.add(648);

        SumFinder sumFinder = new SumFinder();

        for (int currentNumber = 0; currentNumber < numbers.size(); currentNumber++) {
            Integer result = sumFinder.getFactorialDigitsSum(numbers.get(currentNumber));
            assertEquals("Not equals", correctAswers.get(currentNumber), result);
        }
    }
}
