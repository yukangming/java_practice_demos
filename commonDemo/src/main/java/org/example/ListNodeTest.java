package org.example;

import lombok.Data;

public class ListNodeTest {

    @Data
    class ListNode {
        private int val;

        private ListNode next;

    }


    public static void main(String[] args) {

    }

    public boolean judgeCircle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}
