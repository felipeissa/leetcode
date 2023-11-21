package com.felipe.issa.leetcode.exercices;

import java.util.ArrayList;
import java.util.List;

public class _20ValidParentheses {

    public boolean isValid(String s) {
        List<Character> stacked = new ArrayList();


        for(Character current: s.toCharArray()) {
            if(current == '(' || current == '[' || current == '{') {
                stacked.add(current);
            }
            else {
                if(stacked.isEmpty()) return false;
                Character last = stacked.remove(stacked.size() -1);
                if(current == ')') {
                    if (last != '(') return false;
                }
                else if(current == ']') {
                    if (last != '[') return false;
                }
                else if(current == '}') {
                    if (last != '{') return false;
                }
            }
        }

        return stacked.isEmpty();
    }

    public static void main(String[] args) {
        boolean isValid = new _20ValidParentheses().isValid("()");
        System.out.println("Is valid: " + isValid +", should be true");
        isValid = new _20ValidParentheses().isValid("()[]{}");
        System.out.println("Is valid: " + isValid +", should be true");
        isValid = new _20ValidParentheses().isValid("()([]{})");
        System.out.println("Is valid: " + isValid +", should be true");
        isValid = new _20ValidParentheses().isValid("({");
        System.out.println("Is valid: " + isValid +", should be true");
    }
}
