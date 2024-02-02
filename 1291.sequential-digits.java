/*
 * @lc app=leetcode id=1291 lang=java
 *
 * [1291] Sequential Digits
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private int createSequentialDigitInteger(int unitPlace, int length) {
        /* Unit place has already taken 1 place, so reduce length by 1 */
        length--;
        int sequentialDigitNum = unitPlace;
        int base = 10;
        while(length-- > 0) {
            sequentialDigitNum += (base * (unitPlace - 1)) ;
            unitPlace--;
            base *= 10;
        }
        return sequentialDigitNum;
    }   

    public List<Integer> sequentialDigits(int low, int high) {
        /* Create all the sequential digits integers
         * most likely they are around 100 (10 each at each length)
         * (10,100) -> 12,23,34,45,56, like so on...
         * ....
         *  
         */
        List<Integer> sequentialDigitsNums = new ArrayList<>();
        for (int i = 2; i <= 9; i++) {
            for(int j = 2; j <= i; j++) {
                int sequentialDigitNum = createSequentialDigitInteger(i, j);
                if(sequentialDigitNum >= low && sequentialDigitNum <= high)
                    sequentialDigitsNums.add(createSequentialDigitInteger(i, j));
            }
        }
        Collections.sort(sequentialDigitsNums);
        return sequentialDigitsNums;
    }  
}
// @lc code=end

