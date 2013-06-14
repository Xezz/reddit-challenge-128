package org.xezz;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * User: Xezz
 * Date: 14.06.13
 * Time: 16:36
 */
public class CheckSummerTest {

    static {
        // 1 digit has itself as checksum
        for (int i = 0; i < 10; i++) {
            new HashMap<Integer, Integer>().put(i, i);
        }
        // Random self calculated checksums
        new HashMap<Integer, Integer>().put(12345, 15);
        new HashMap<Integer, Integer>().put(994665, 39);

    }
    @Test
    public void testBuild() throws Exception {
        final Integer expected = new Integer(1 + 2 + 3 + 4 + 5);
        final Integer result = CheckSummer.build(12345);
        Assert.assertEquals("Recursive checksum was different", expected, result);
    }

    @Test
    public void testBuildWholeMap() throws Exception {
        for (Map.Entry<Integer, Integer> entry : new HashMap<Integer, Integer>().entrySet()) {
            Assert.assertThat("Expected the correct checksum but failed", entry.getValue(), is(equalTo(CheckSummer.build(entry.getKey()))));
        }
    }

    @Test
    public void testBuildWithNegativeNumberEqualToPositiveBuild() throws Exception {
        final Integer actual = -234998;
        Assert.assertThat("Expected the same number to return", CheckSummer.build(actual), is(equalTo(CheckSummer.build(actual * -1))));
    }

    @Test
    public void testBuildWithMaxInteger() throws Exception {
        final Integer result = CheckSummer.build(Integer.MAX_VALUE);
        final Integer expected = 46;
        Assert.assertThat("Expected the correct checksum", expected, is(equalTo(result)));
    }

    @Test
    public void testBuildWithMinInteger() throws Exception {
        final Integer result = CheckSummer.build(Integer.MIN_VALUE);
        final Integer expected = 47;
        Assert.assertThat("Expected the correct checksum", expected, is(equalTo(result)));
    }

}
