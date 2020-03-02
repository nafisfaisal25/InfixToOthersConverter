package com.example.infixtoothersconverter;

import java.util.Stack;

public class Evaluator {

    public Evaluator() {
    }


    public double evaluatePostFix(String str) {
        double result = 0;
        Stack<Double> stack = new Stack<>();
        String [] numberList = str.split(" ");

        for(int i=0;i<numberList.length;i++) {
            String c = numberList[i];
            if(c.equals("+")) {
                result = stack.pop() + stack.pop();
                stack.push(result);
            } else if(c.equals("-")) {
                result = -stack.pop() + stack.pop();
                stack.push(result);
            } else if(c.equals("*")) {
                result = stack.pop() * stack.pop();
                stack.push(result);
            } else if(c.equals("/")) {
                result = 1/stack.pop() * stack.pop();
                stack.push(result);
            } else{
                stack.push(convertToNumber(c));
            }
        }
        return result;
    }

    private Double convertToNumber(String str) {
        double result = 0;
        int j = str.length() - 1;
        for(int i = 0; i < str.length();i++) {
            result += (str.charAt(i) - '0') * Math.pow(10,j--);
        }
        return result;
    }
}
