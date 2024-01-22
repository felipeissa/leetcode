package com.felipe.issa.leetcode.exercices;

import java.util.*;

public class _380RandomSet {
    class RandomizedSet {
        private Map<Integer, Integer> valuesAndIndex;
        private List<Integer> values;
        public RandomizedSet() {
             valuesAndIndex = new HashMap<>();
             values = new ArrayList();
        }

        public boolean insert(int val) {
            boolean contains = valuesAndIndex.containsKey(val);
            if(!contains) {
                valuesAndIndex.put(val, values.size());
                values.add(val);
            }
            System.out.println(values);
            return !contains;
        }

        public boolean remove(int val) {
            int index = valuesAndIndex.getOrDefault(val, -1);
            if(index >= 0) {
                valuesAndIndex.remove(val);
                if(values.size() > 1) {
                    int valueChanging = values.get(values.size() -1);
                    values.set(index, valueChanging);
                    valuesAndIndex.replace(valueChanging, index);
                    values.remove(values.size()-1);
                } else {
                    values.clear();
                }
            }
            return index >= 0;
        }

        public int getRandom() {
            return values.get((int) (Math.random() * values.size()));
        }
    }
}
