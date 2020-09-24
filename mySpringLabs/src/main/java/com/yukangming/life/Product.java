package com.yukangming.life;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean, DisposableBean {
//    public class Product{
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        System.out.println("this is setName method");
        this.productName = productName;
    }

    public Product() {
        System.out.println("Product producted.....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Product afterPropertiesSet....");
    }

    public void myInit() {
        System.out.println("it's my own initial method......");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Product destoryed........");
    }
}
