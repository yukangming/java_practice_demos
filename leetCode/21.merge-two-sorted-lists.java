/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode newRoot=new ListNode(0);
       ListNode node=newRoot;
       while(l1!=null||l2!=null)
       {
           if(l1==null)
           {
               node.next=l2;
               break;
           }
           if(l2==null)
           {
               node.next=l1;
               break;
           }
           if(l1.val<=l2.val)
           {
               node.next=l1;
               l1=l1.next;
           }
           else
           {
               node.next=l2;
               l2=l2.next;
           }
           node=node.next;
       }
       return newRoot.next;
    }
}
// @lc code=end

