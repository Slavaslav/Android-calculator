package com.slava.calc;

import java.util.LinkedList;

public class Calculator {

    private static void calc(LinkedList<Double> st, char op) {
        double r = st.removeLast();
        double l = st.removeLast();
        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '×':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
        }
    }

    private static int priority(char op) {
        switch (op) {
            case '/':
            case '×':
                return 2;
            case '-':
            case '+':
                return 1;
            default:
                return 0;
        }
    }

    private static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '/':
            case '×':
                return true;
            default:
                return false;
        }
    }

    public static double evaluate(String s) {
        LinkedList<Double> st = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    calc(st, op.removeLast());
                op.add(c);
            } else if (c == '(')
                op.add(c);
            else if (c == ')') {
                while (op.getLast() != '(')
                    calc(st, op.removeLast());
                op.removeLast();
            } else {
                String ch = "";
                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
                    ch = ch + s.charAt(i++);
                }
                i--;
                st.add(Double.parseDouble(ch));
            }
        }
        while (!op.isEmpty())
            calc(st, op.removeLast());
        return st.get(0);
    }

}
