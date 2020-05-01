/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        long n = 0;
        while(x!=0){
            n = n*10+x%10;
            x=x/10;
        }
        if(n>Integer.MAX_VALUE||n<Integer.MIN_VALUE)
        return 0;
        else
        return (int) n;
    }
}
// @lc code=end

