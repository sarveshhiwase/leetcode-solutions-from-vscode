/*
 * @lc app=leetcode id=3019 lang=java
 *
 * [3019] Number of Changing Keys
 */

// @lc code=start
class Solution {
    public int countKeyChanges(String s) {
        int len = s.length();
        s = s.toLowerCase();

        int keysChanged = 0;

        for(int i = 1; i < len; i++) {
            if(s.charAt(i) != s.charAt(i - 1)) keysChanged++;
        }

        return keysChanged;
    }
}
// @lc code=end

