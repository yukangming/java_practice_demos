package org.example;

/**
 * 测试栈溢出
 */
public class JavaStacksOF {


    private int stackLength = 1;

    public void stackLenth() {
        stackLength++;
        stackLenth();
    }


    public static void main(String[] args) {
        JavaStacksOF javaStacksOF = new JavaStacksOF();
        try {
            javaStacksOF.stackLenth();
        } catch (Exception e) {
            System.out.println("stack length is " + javaStacksOF.stackLength);
            throw e;
        }
    }
}
