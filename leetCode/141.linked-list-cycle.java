import java.util.Set;

/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> node=new HashSet<>();
        while(head!=null){
            if(node.contains(head)){
                return true;
            }else{
                node.add(head);
            }
            head=head.next;
        }
        return false;
    }
}
// @lc code=end

