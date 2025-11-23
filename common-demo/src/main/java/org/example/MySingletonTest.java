package org.example;


import lombok.Data;

@Data
public class MySingletonTest {


    private MySingletonTest() {
    }

    private static volatile MySingletonTest mySingletonTest = null;

    public static  MySingletonTest getInstance() {
        if (mySingletonTest == null) {
            synchronized (MySingletonTest.class) {
                if (mySingletonTest == null) {
                    mySingletonTest = new MySingletonTest();
//                    return mySingletonTest;
                }
//                return mySingletonTest;
            }
        }

        return mySingletonTest;
    }

    public static void main(String[] args) {

    }





}
