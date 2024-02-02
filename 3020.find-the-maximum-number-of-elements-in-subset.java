/*
 * @lc app=leetcode id=3020 lang=java
 *
 * [3020] Find the Maximum Number of Elements in Subset
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int maximumLength(int[] nums) {
        Map<Long,Long> mp = new HashMap<>();
        for(int num: nums) {
            mp.put((long)num, mp.getOrDefault((long)num, (long)0) + 1L);
        }

        long maxLen = 0;
        for(Map.Entry<Long,Long> entry: mp.entrySet()) {
            long num = entry.getKey();
            long count = entry.getValue();

            // if element is 1
            if(num == 1) {
                maxLen = Math.max(maxLen, (count & 1) == 1 ? count : count - 1);
                continue;
            }

            // if element is not 1
            int k = 0;
            int currSize = 0;
            List<Long> foundElements = new ArrayList<>();
            long startingNum = (long)Math.pow(num, (long)Math.pow(2, k));
            while(mp.containsKey(startingNum)) {
                k++;
                foundElements.add(startingNum);
                currSize++;
                boolean isGoodList = true;

                for(int i = 0; i < currSize - 1; i++) {
                    if(mp.get(foundElements.get(i)) < 2) {
                        isGoodList = false;
                        break;
                    }
                }

                if(isGoodList) {
                    maxLen = Math.max(maxLen, 2L * (currSize - 1) + 1);
                }
                startingNum = (long)Math.pow(num, (long)Math.pow(2, k));
            }
            
        }

        return (int)maxLen;
    }
}
// @lc code=end

