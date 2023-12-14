package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class _804UniqueMorse {
	
	private static String[] MORSE_VALUES = new String[] { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

	public int uniqueMorseRepresentations(String[] words) {
        Set<String> values = Arrays.stream(words)
        	.map(word -> 
        		Arrays.stream(word.split(""))
        			.map(character -> StringtoMorseCode(character))
        			.collect(Collectors.joining())
        	).collect(Collectors.toSet());
        
        return values.size();
    }
	
	private String StringtoMorseCode(String character) {
		return MORSE_VALUES[character.charAt(0) - 'a'];
	}

	@Test
	public void firstCase() {
		int output = new _804UniqueMorse().uniqueMorseRepresentations(new String[] {"gin","zen","gig","msg" });
		assertEquals(2, output);
	}
}
