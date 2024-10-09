package org.example;

public class RequestHandlerImp1 implements RequestHandler{
    @Override
    public void processRequest(String request) {
        System.out.println("this is imp1 process");
    }
}
