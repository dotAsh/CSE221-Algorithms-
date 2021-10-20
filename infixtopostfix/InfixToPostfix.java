
package infixtopostfix;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    public static String postFixBuilder(String s) {
        Stack<Character> myStack = new Stack<>();
        String postFix = "";
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            char ch = a[i];
            if (Character.isDigit(ch)) {
                postFix = postFix + ch;
            } else {
                if (ch != '(' && ch != ')' && ch != '{' && ch != '}' && ch != '[' && ch != ']') {
                    if (myStack.isEmpty()) {
                        myStack.push(ch);
                    } else {
                        while (getPrecedence(myStack.peek()) >= getPrecedence(ch)) {
                            postFix = postFix + myStack.pop();
                            if (myStack.isEmpty()) {
                                break;
                            }
                        }
                        myStack.push(ch);
                    }
                } else {
                    if (ch == '(') {
                        myStack.push(ch);
                    } else if (ch == ')') {
                        while (myStack.peek() != '(') {
                            postFix = postFix + myStack.pop();
                        }
                        myStack.pop();
                    }
                    if (ch == '{') {
                        myStack.push(ch);
                    } else if (ch == '}') {
                        while (myStack.peek() != '{') {
                            postFix = postFix + myStack.pop();
                        }
                        myStack.pop();
                    }
                    if (ch == '[') {
                        myStack.push(ch);
                    } else if (ch == ']') {
                        while (myStack.peek() != '[') {
                            postFix = postFix + myStack.pop();
                        }
                        myStack.pop();
                    }
                }
            }

        }
        while (!myStack.isEmpty()) {
            postFix = postFix + myStack.pop();
        }
        return postFix;

    }

    public static int getPrecedence(char a) {
        if (a == '+' || a == '-') {
            return 1;
        }
        if (a == '*' || a == '/' || a=='%') {
            return 2;
        }
        return -1;
    }

    public static int postFixEvaluator(String postFix) {
        Stack<Integer> myStack = new Stack<>();
        for (int i = 0; i < postFix.length(); i++) {
            char a = postFix.charAt(i);
            if (Character.isDigit(a)) {
                String ab = "" + a;
                myStack.push(Integer.parseInt(ab));
            } else {
                int op1 = myStack.pop();
                int op2 = myStack.pop();
                if (a == '+') {
                    myStack.push(op2 + op1);
                } else if (a == '-') {
                    myStack.push(op2 - op1);
                } else if (a == '/') {
                    myStack.push(op2 / op1);
                } else if (a == '*') {
                    myStack.push(op2 * op1);
                }else if(a=='%'){
                    myStack.push(op2%op1);
                }
            }
        }
        return myStack.pop();
    }

    public static void main(String[] args) {
        String exp = new Scanner(System.in).next();
        String postFixExp = postFixBuilder(exp);
        System.out.println("Post Fix Expression: " + postFixExp);
        int result = postFixEvaluator(postFixExp);
        System.out.println("Answer: " + result);
    }
}
