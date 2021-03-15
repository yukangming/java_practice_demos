//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 110 👎 0


package com.yukangming.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        int count = 0;
        while (head!= null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count++;
        }
        int[] res = new int[count];
        count = 0;
        while (pre.next != null) {
            res[count++] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
