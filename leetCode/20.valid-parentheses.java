import sun.security.util.Length;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
       char[] stack = new char[s.length()];
       int top = 0;
        for (char c : s.toCharArray()) {
            switch(c){
                case '{':stack[top++] = '}';break;
                case '(':stack[top++] = ')';break;
                case '[':stack[top++] = ']';break;
                default:if(top==0||stack[--top]!=c) return false;
            }
        }
        return top==0;
    }
}
// @lc code=end

