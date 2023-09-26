package org.example;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
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
        System.out.println("======");
        System.out.println("判断是否是二叉搜索树");
        Boolean bst = isBST(head);
        System.out.println(bst);
        System.out.println("======");
        System.out.println("判断是否是平衡二叉树");
        TreePractice treePractice = new TreePractice();
        boolean balance = treePractice.isBalance(head);
        System.out.println(balance);
        System.out.println("======");
        System.out.println("判断是否是二叉搜索树");
        Boolean b = checkBST2(head);
        System.out.println(b);


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
                System.out.println(s2.pop().value + " ");
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
                } else {
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

    private static int preValue = Integer.MIN_VALUE;

    /**
     * 递归判断是否是二叉搜索树
     */
    public static Boolean isBST(Node head) {
        if (head == null) {
            return true;
        }

        Boolean bst = isBST(head.left);
        if (Boolean.FALSE.equals(bst)) {
            return false;
        }

        if (head.value <= preValue) {
            return false;
        } else {
            preValue = head.value;
        }

        return isBST(head.right);
    }


    /**
     * 非递归判断是否是二叉搜索是
     *
     */
    public static Boolean checkBST2(Node head) {
        if (head != null) {
            int preValue = Integer.MIN_VALUE;
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    Node pop = stack.pop();
                    if (pop.value <= preValue) {
                        return false;
                    } else {
                        preValue = pop.value;
                    }

                    head = pop.right;
                }
            }

        }

        return true;
    }

    /**
     * 判断是否是完全二叉树
     *
     */
    public  static boolean checkCompleteTree(Node head) {
        if (head != null) {
            Queue<Node> queue = new LinkedList<>();
            boolean leaf = false;
            Node left;
            Node right;
            queue.add(head);
            while (!queue.isEmpty()) {
                Node poll = queue.poll();
                left = poll.left;
                right = poll.right;

                if (leaf && (left != null && right != null) || (left == null && right != null)) {
                    return false;
                }
                if (left != null) {
                    queue.add(left);
                }

                if (right != null) {
                    queue.add(right);
                }


                if (left == null || right == null) {
                    leaf = true;
                }

            }
        }

        return true;

    }

    /**
     * 判断是否是平衡二叉树
     *
     */
    public boolean isBalance(Node head) {
        return process(head).isBalance;
    }


    public static class ReturnType {
        public ReturnType(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }

        private final int height;

        private final boolean isBalance;
    }

    public ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(0, true);
        }

        ReturnType left = process(head.left);

        ReturnType right = process(head.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalance = left.isBalance && right.isBalance && (Math.abs(left.height - right.height) < 2);
        return new ReturnType(height, isBalance);

    }


    /**
     * 树形dp判断是否是二叉搜索树
     */
    public boolean checkBST(Node head) {
        return processBST(head).isBST;
    }


    @Data
    public static class ReturnData {
        private boolean isBST;

        private int max;

        private int min;

        public ReturnData(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

    public ReturnData processBST(Node head) {
        if (head == null) {
            return null;
        }

        int min = head.value;
        int max = head.value;

        ReturnData leftData = processBST(head.left);
        if (leftData != null) {
            min = Math.min(leftData.min, head.value);
            max = Math.max(leftData.max, head.value);
        }

        ReturnData rightData = processBST(head.right);
        if (rightData != null) {
            min = Math.min(rightData.min, head.value);
            max = Math.max(rightData.max, head.value);
        }

        boolean isBST = leftData == null || (leftData.isBST && (leftData.max < head.value));

        if (rightData != null && (!rightData.isBST || (rightData.min <= head.value))) {
            isBST = false;
        }

        return new ReturnData(isBST, max, min);
    }


    /**
     * 查找最近公共祖先
     * @param head
     * @param o1
     * @param o2
     * @return
     */
    public Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }

        Node node = lowestAncestor(head.left, o1, o2);
        Node node1 = lowestAncestor(head.right, o1, o2);

        if (node != null && node1 != null) {
            return head;
        }


        return node1 == null ? node : node1;
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
