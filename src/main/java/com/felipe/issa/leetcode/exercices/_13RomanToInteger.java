package com.felipe.issa.leetcode.exercices;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class _13RomanToInteger {
	
	 public int romanToInt(String s) {
        List<Integer> translated = Arrays.stream(s.split("")).map(roman -> romanValue(roman)).collect(Collectors.toList());
        int value = 0; 
        int size = translated.size();
        for(int i = 0; i < size; i++) {
        	int current = translated.get(i);
        	int next = i+1 < size ? translated.get(i+1) : 0;
        	
        	if(current >= next) {
        		value += current;
        	} else {
        		value -= current;
        	}
        }
        return value;
    }
	    
    private int romanValue(String s) {
        switch (s) {
            case "I":
                return 1;
            case "V": 
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            default:
            	return 0;
        }
    }

	public static void main(String[] args) {
		Map<String, Integer> values = new HashMap<>();
		values.put("III", 3);
		values.put("LVIII", 58);
//		values.put("MCMXCIV", 1994);
		values.put("MCMXCIV", 1994);
		values.keySet().forEach(key -> {
			System.out.println("Value: " + key + ", expected: " + values.get(key) + ", got: " + new _13RomanToInteger().romanToInt(key));
		});

	}

}
