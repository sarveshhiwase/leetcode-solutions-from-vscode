/*
 * @lc app=leetcode id=2966 lang=java
 *
 * [2966] Divide Array Into Arrays With Max Difference
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < len) {
            List<Integer> lst = new ArrayList<>();
            while(j < len && nums[j] - nums[i] <= k) {
                lst.add(nums[j]);
                j++;
                if((j - i) >= 3) break;
            }
            // if at any point we don't have array size of greater than 3
            if((j - i) < 3) return new int[][]{};
            answer.add(lst);
            i = j;
        }

        return answer.stream()
                .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
// @lc code=end

