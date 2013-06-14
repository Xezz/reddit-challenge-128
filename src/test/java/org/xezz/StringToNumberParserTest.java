package org.xezz;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


/**
 * User: Xezz
 * Date: 14.06.13
 * Time: 16:46
 */
public class StringToNumberParserTest {

    @Test
    public void testParseStringToInteger() throws Exception {
        final String toParse = "12345";
        final Integer parseResult = StringToNumberParser.parse(toParse);
        final Integer expected = new Integer(12345);
        Assert.assertEquals("Numbers do not equal", expected, parseResult);
    }

    @Test(expected = NumberFormatException.class)
    public void testParseStringThrowsException() throws Exception {
        StringToNumberParser.parse("9342a");
    }

    @Test
    public void testParseStringNegativeNumber() throws Exception {
        final String toParse = "-123456";
        final Integer expected = -123456;
        final Integer parseResult = StringToNumberParser.parse(toParse);
        Assert.assertThat("String and Integer are not the same", expected, is(equalTo(parseResult)));
    }


}
