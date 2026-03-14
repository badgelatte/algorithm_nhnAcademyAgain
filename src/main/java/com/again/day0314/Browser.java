package com.again.day0314;

import java.util.Stack;

public class Browser {

    private final Stack<String> backStack = new Stack<>();
    private final Stack<String> forwardStack = new Stack<>();

    private Browser(String welcomePage){
        visit(welcomePage);
    }

    public static Browser of(){
        return new Browser("http://nhnacademy.com");
    }

    public void visit(String url){
        backStack.push(url);
        forwardStack.clear();
    }

    public String back(int steps){
        String url = "";

        for (int i = 0; i < steps; i++) {
            url = backStack.pop();
            forwardStack.push(url);
        }

        return backStack.peek();
    }

    public String forward(int steps) {
        String url = "";

        for (int i = 0; i < steps; i++) {
            url = forwardStack.pop();
            backStack.push(url);
        }

        return backStack.peek();
    }

}