package org.xezz;

/**
 * User: Xezz
 * Date: 14.06.13
 * Time: 16:23
 */
public class StringToNumberParser {
    /**
     * Parse a given input String and return the Integer repesentation
     *
     * @param toParse String representation of a number
     * @return Integer value of the String
     * @throws NumberFormatException if the given String is not of a valid format
     */
    public static Integer parse(final String toParse) {
        return Integer.parseInt(toParse);
    }
}
