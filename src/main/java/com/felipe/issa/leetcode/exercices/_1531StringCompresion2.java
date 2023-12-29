package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.Pair;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class _1531StringCompresion2 {


    public int getLengthOfOptimalCompression(String s, int k) {
        if(s.length() == 0) return 0;

        List<Pair<Character, Integer>> db = new ArrayList<>();
        int index = 0;
        db.add(index, new Pair<>(s.charAt(0), 1));
        for(int i = 1; i < s.length(); i++) {
            Pair<Character, Integer> current = db.get(index);
            if(s.charAt(i) == current.getKey()) {
                db.remove(index);
                db.add(index, new Pair(current.getKey(), current.getValue()+1));
                continue;
            }

            db.add(++index, new Pair<>(s.charAt(i), 1));
        }

        if(k == 0)  return calculateOutput(db);

        k = removeBetweens(k, db);
        groupSames(db);

        if(k == 0)  return calculateOutput(db);

        k = decrease10(k, db);

        k = removeSmallerThanK(k, db);
        groupSames(db);

        if(k == 0)  return calculateOutput(db);

        k = removeSizeOne(k, db);
        groupSames(db);


        return calculateOutput(db);
    }

    private static int removeSizeOne(int k, List<Pair<Character, Integer>> db) {
        for(int i = 0; i < db.size() && k > 0; i++) {
            Pair<Character, Integer> pair = db.get(i);
            if(pair.getValue() == 1 && pair.getValue() <= k) {
                k -= pair.getValue();
                db.remove(i);
            }
        }
        return k;
    }

    private int decrease10(int k, List<Pair<Character, Integer>> db) {
        for(int i = 0; i < db.size(); i++) {
            Pair<Character, Integer> pair = db.get(i);
            if(pair.getValue() == 10 && k > 2) {
                k -= 1;
                db.set(i, new Pair<>(pair.getKey(), pair.getValue() -1));
            }
        }
        return k;
    }

    private int removeSmallerThanK(int k, List<Pair<Character, Integer>> db) {
        for(int i = 0; i < db.size(); i++) {
            Pair<Character, Integer> pair = db.get(i);
            if(pair.getValue() > 1 && pair.getValue() < k) {
                k -= pair.getValue();
                db.remove(i);
            }
        }
        return k;
    }

    private static int removeBetweens(int k, List<Pair<Character, Integer>> db) {
        for(int i = 1; i < (db.size() -1); i++) { // remove betweens
            Pair<Character, Integer> pair = db.get(i);
            if(pair.getValue() <= k && db.get(i-1).getKey() == db.get(i+1).getKey()) {
                k -= pair.getValue();
                db.remove(i);
            }
        }
        return k;
    }

    public void groupSames(List<Pair<Character, Integer>> db) {
        for(int i = 0; i < db.size(); i++) {
            Pair<Character, Integer> current = db.get(i);
            while(i +1 < db.size() && db.get(i+1).getKey() == current.getKey() ) {
                current = new Pair<>(current.getKey(), current.getValue() + db.get(i+1).getValue());
                db.set(i, current);
                db.remove(i+1);
            }
        }
    }

    public int calculateOutput(List<Pair<Character, Integer>> db) {
        int count = 0;
        for(int i = 0; i < db.size(); i++ ) {
            Pair<Character, Integer> pair = db.get(i);
            int charCount = pair.getValue();
            while( i+1 < db.size() && db.get(i+1).getKey() == pair.getKey()) {
                charCount += pair.getValue();
                i++;
            }
            count++; // leter
            if(charCount > 1)
                count+= Integer.toString(charCount).length();
        }

        return count;
    }


    @Test
    public void firstCase() {
        int output = new _1531StringCompresion2().getLengthOfOptimalCompression("aaabcccd", 2);
        assertEquals(4, output);
    }

    @Test
    public void secondCase() {
        int output = new _1531StringCompresion2().getLengthOfOptimalCompression("aabbaa", 2);
        assertEquals(2, output);
    }

    @Test
    public void thirdCase() {
        int output = new _1531StringCompresion2().getLengthOfOptimalCompression("aaaaaaaaaaa", 0);
        assertEquals(3, output);
    }

    @Test
    public void test20() {
        int output = new _1531StringCompresion2().getLengthOfOptimalCompression("abc", 2);
        assertEquals(1, output);
    }

    @Test
    public void test40() {
        int output = new _1531StringCompresion2().getLengthOfOptimalCompression("aabaabbcbbbaccc", 6);
        assertEquals(4, output);
    }

    @Test
    public void test24() {
        int output = new _1531StringCompresion2().getLengthOfOptimalCompression("bbabbbabbbbcbb", 4);
        assertEquals(4, output);
    }

    @Test
    public void test35() {
        int output = new _1531StringCompresion2().getLengthOfOptimalCompression("bbabbbabbbbcbb", 4);
        assertEquals(4, output);
    }
}
