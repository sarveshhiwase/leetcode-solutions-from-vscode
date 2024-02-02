/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];

        Stack<Integer[]> st = new Stack<>();

        for(int i = len - 1; i >= 0; i--) {
            while(!st.empty() && st.peek()[0] <= temperatures[i]) {
                st.pop();
            }
            answer[i] = st.empty() ? 0 : st.peek()[1] - i;
            st.push(new Integer[]{temperatures[i], i});
        }

        return answer;
    }
}
// @lc code=end

