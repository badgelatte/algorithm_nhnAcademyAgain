package com.again.day0314;

// 1026에 완성한 풀이
import java.util.Stack;

public class OldBrowser {
    static String browser;
    private final Stack<String> backStack = new Stack<>();
    private final Stack<String> forwardStack = new Stack<>();

    private OldBrowser(String welcomePage){
        browser = welcomePage;
    }

    public static OldBrowser of(){

        return new OldBrowser("http://nhnacademy.com");
    }

    public void visit(String url){
        backStack.push(url);
        forwardStack.clear();
    }

    public String back(int steps){
        while(steps-- > 0) {
            forwardStack.push(backStack.pop());
        }
        return backStack.peek();
    }

    public String forward(int steps) {
        while(steps-- > 0) {
            backStack.push(forwardStack.pop());
        }
        return backStack.peek();
    }

}