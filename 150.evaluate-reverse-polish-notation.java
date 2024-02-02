/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new LinkedList<>();

        for(String token: tokens) {
            int x = -1;
            int y = -1;
            switch (token) {
                case "+":
                    x = st.pollLast();
                    y = st.pollLast();
                    st.offerLast(y + x);
                    break;
                case "-":
                    x = st.pollLast();
                    y = st.pollLast();
                    st.offerLast(y - x);
                    break;
                case "/":
                    x = st.pollLast();
                    y = st.pollLast();
                    st.offerLast(y / x);
                    break;
                case "*":
                    x = st.pollLast();
                    y = st.pollLast();
                    st.offerLast(y * x);
                    break;
                default:
                    st.offerLast(Integer.valueOf(token));
                    break;
            }
        }
        return st.peek();
    }
}
// @lc code=end

