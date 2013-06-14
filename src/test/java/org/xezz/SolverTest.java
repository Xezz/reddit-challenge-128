package org.xezz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

/**
 * User: Xezz
 * Date: 14.06.13
 * Time: 18:42
 */
public class SolverTest {
    @Test
    public void testSolve() throws Exception {
        final String input = "12345";
        final List<Integer> expectedList = Arrays.asList(6, 15, 12345);
        final List<Integer> result = Solver.solve(input);
        Assert.assertThat("Results not as expected", expectedList, hasItems(result.toArray(new Integer[result.size()])));
        Assert.assertThat("Results not as expected", result, hasItems(expectedList.toArray(new Integer[expectedList.size()])));
    }
}
