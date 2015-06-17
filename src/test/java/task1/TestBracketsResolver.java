package task1;

import com.mr_faton.task1.core.BracketsResolver;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

public class TestBracketsResolver {
    @Test
    public void testBR() {
        int openBracketsCount = 2;
        Collection<String> bracketsExpressions = new ArrayList<>();
        String expr0 = "()()";
        String expr1 = "(())";
        String expr2 = "((()))";
        String expr3 = "(()";
        bracketsExpressions.add(expr0);
        bracketsExpressions.add(expr1);
        bracketsExpressions.add(expr2);
        bracketsExpressions.add(expr3);

        BracketsResolver bracketsResolver = new BracketsResolver(openBracketsCount, bracketsExpressions);

        Collection<String> satisfyExpressions = bracketsResolver.getSatisfyExpressions();

        assertNotNull("The satisfyExpressions collection is null", satisfyExpressions);
        assertTrue("The satisfyExpressions collection is empty", !satisfyExpressions.isEmpty());

        Iterator<String> iterator = satisfyExpressions.iterator();
        assertTrue("Iterator has no next", iterator.hasNext());
        String testExpr = iterator.next();
        assertEquals("Don't equals", expr1, testExpr);

        for (String expression : satisfyExpressions) {
            System.out.println(expression);
        }
    }
}
