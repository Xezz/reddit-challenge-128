package org.xezz;

/**
 * User: Xezz
 * Date: 14.06.13
 * Time: 16:28
 * Calculate the checksum of all digits of a given number
 */
public class CheckSummer {

    /**
     * Build the checksum of an integer
     *
     * @param number The Integer to build the Checksum from
     * @return Integer checksum of all digits of the given Integer
     */
    public static Integer build(final Integer number) {
        if (number == Integer.MIN_VALUE) {
            return 1 + build(number + 1);
        }
        if (number < 0) {
            return build(number * -1);
        }
        if (number < 10) {
            return number;
        } else {
            return number % 10 + build(number / 10);
        }
    }
}
