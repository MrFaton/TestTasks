package task2;

import com.mr_faton.task3.core.SumFinder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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

        for (int i = 0; i < numbers.size(); i++) {
            SumFinder sumFinder = new SumFinder(numbers.get(i));
            Integer result = sumFinder.getFactorialDigitsSum();
            assertEquals("Not equals", correctAswers.get(i), result);
        }
    }
}
