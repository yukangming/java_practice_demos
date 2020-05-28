/*
 * @lc app=leetcode id=876 lang=java
 *
 * [876] Middle of the Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while(curr!=null){
            len++;
            curr = curr.next;
        }
        len = len/2;
        if(len==0) return head;
        curr = head;
        while(len>0){
            curr = curr.next;
            len--;
        }
        return curr;
    }
}
// @lc code=end

