package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void firstCase(){
        boolean isValid = new _20ValidParentheses().isValid("()");
        assertTrue(isValid);
    }

    @Test
    public void secondCase(){
        boolean isValid = new _20ValidParentheses().isValid("()[]{}");
        assertTrue(isValid);
    }

    @Test
    public void thirdCase(){
        boolean isValid = new _20ValidParentheses().isValid("()([]{})");
        assertTrue(isValid);
    }

    @Test
    public void forthCase(){
        boolean isValid = new _20ValidParentheses().isValid("({");
        assertFalse(isValid);
    }
}
