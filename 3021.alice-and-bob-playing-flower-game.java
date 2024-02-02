/*
 * @lc app=leetcode id=3021 lang=java
 *
 * [3021] Alice and Bob Playing Flower Game
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    private int[] evenOddTillNum(int n) {
        boolean isOdd = (n & 1) == 1;
        // even no's till N, odd no's till N
        return new int[]{n / 2, n / 2 + (isOdd ? 1 : 0)};
    }
    public long flowerGame(int n, int m) {
        // find the no. with odd sum
        int[] x_count = evenOddTillNum(n);
        int[] y_count = evenOddTillNum(m);

        int x_even = x_count[0];
        int x_odd = x_count[1];
        int y_even = y_count[0];
        int y_odd = y_count[1];

        return (x_even * 1L * y_odd) + (x_odd * 1L * y_even);
    }
}
// @lc code=end

