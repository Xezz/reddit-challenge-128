package org.xezz;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Xezz
 * Date: 14.06.13
 * Time: 16:52
 */
public class Solver {

    /**
     * Calculate the checksum of any given input and of the result until only a single digit is left
     * @param input String representing the number to calculate
     * @return List of Integers containing all steps of solving this
     * @throws NumberFormatException if the given input is not a valid number
     */
    public static List<Integer> solve(final String input) {
        Integer result = StringToNumberParser.parse(input);
        final List<Integer> checksumList = new ArrayList<Integer>();
        checksumList.add(result);
        while (result >= 10 || result <= -10) {
            result = CheckSummer.build(result);
            checksumList.add(result);
        }
        return checksumList;
    }
}
