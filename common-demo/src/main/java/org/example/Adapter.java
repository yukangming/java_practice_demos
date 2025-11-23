package org.example;

/**
 * 适配器模式，将不满足ITarget接口的类 Adaptee 转变为满足接口定义方式
 */
public class Adapter extends Adaptee implements ITarget{
    @Override
    public void metho1() {
        super.processMethod1();
    }

    @Override
    public void metho2() {
        super.processMethod2();
    }

    @Override
    public void metho3() {
        super.processMethod3();
    }
}
