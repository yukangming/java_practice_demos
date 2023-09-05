package org.example;

import lombok.Data;

import java.util.Stack;

/**
 * @author ykm
 * 练习二叉树基本操作
 */
@Data
public class TreePractice {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.setLeft(new Node(3));
        head.setRight(new Node(5));
        Node left = head.getLeft();
        left.setLeft(new Node(7));
        left.setRight(new Node(11));
        Node right = head.getRight();
        right.setLeft(new Node(13));
        right.setRight(new Node(15));
        System.out.println("非递归后序遍历");
        postOderNotRecursion(head);
        System.out.println("======");
        System.out.println("递归遍历");
        postOrderRecursion(head);
        System.out.println("======");
        System.out.println("非递归中序遍历");
        postOrderNotRecursion2(head);
        System.out.println("======");
        System.out.println("非递归先序遍历");
        postOrderNotRecursion3(head);
    }

    //非递归后序遍历左右中
    public static void postOderNotRecursion(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }

            while (!s2.isEmpty()) {
                System.out.println(s2.pop().value+ " ");
            }
        }
    }

    public static void postOrderNotRecursion2(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                }
                else {
                    Node pop = stack.pop();
                    System.out.println(pop.value + " ");
                    head = pop.right;
                }
            }
        }
    }


    //非递归先序遍历
    public static void postOrderNotRecursion3(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                Node pop = stack.pop();
                System.out.println(pop.value + " ");
                if (pop.getRight() != null) {
                    stack.push(pop.getRight());
                }
                if (pop.getLeft() != null) {
                    stack.push(pop.getLeft());
                }
            }
        }
    }


    //递归遍历
    public static void postOrderRecursion(Node head) {
        if (head == null) {
            return;
        }
        //可以处理当前节点的地方，前序遍历可以放在这里处理
//        System.out.println(head.value + " ");
        postOrderRecursion(head.left);
        //第二个处理当前节点的地方,中序遍历可以放在这里处理
//        System.out.println(head.value + " ");
        postOrderRecursion(head.right);
        //第三个可以处理当前节点的地方
        System.out.println(head.value + " ");
    }


    @Data
    private static class Node {
        public Node(int value) {
            this.value = value;
        }

        private int value;

        private Node left;

        private Node right;
    }

}
