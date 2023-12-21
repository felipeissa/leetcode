package com.felipe.issa.leetcode.exercices;

import com.felipe.issa.leetcode.shared.ArrayParser;
import com.felipe.issa.leetcode.shared.Pair;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class _2353FoodRatingSystem {

    Map<String, FoodData> foodInfo = new HashMap<>();
    Map<Pair<String, Integer>, Set<String>> cuisineRankFoods = new HashMap<>();
    Map<String, NavigableSet<Integer>> cuisineRanks = new HashMap<>();

    public static class FoodData {
        int rating;
        String cuisine;

        public FoodData(String cuisine, int rating) {
            this.rating = rating;
            this.cuisine = cuisine;
        }
    }

    public void FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int length = foods.length;
        for(int i = 0; i < length; i++) {
            foodInfo.put(foods[i], new FoodData(cuisines[i], ratings[i]));
            addCuisineFood(foods[i], cuisines[i], ratings[i]);
        }

    }

    public void changeRating(String food, int newRating) {
        FoodData foodData = foodInfo.get(food);
        removeCuisineFood(food, foodData.cuisine, foodData.rating);
        addCuisineFood(food, foodData.cuisine, newRating);
        foodData.rating = newRating;
    }

    public String highestRated(String cuisine) {
        Integer ranking = cuisineRanks.get(cuisine).last();
        Set<String> highestFoods = cuisineRankFoods.get(new Pair<>(cuisine, ranking));
        System.out.println(highestFoods);
        return highestFoods.iterator().next();
    }

    private void addCuisineFood(String food, String cuisine, int rating) {
        if(!cuisineRanks.containsKey(cuisine)) {
            cuisineRanks.put(cuisine, new TreeSet<>());
        }
        cuisineRanks.get(cuisine).add(rating);
        Pair<String, Integer> key = new Pair<>(cuisine, rating);
        if(!cuisineRankFoods.containsKey(key)) {
            cuisineRankFoods.put(key, new TreeSet<>());
        }
        cuisineRankFoods.get(key).add(food);
    }

    private void removeCuisineFood(String food, String cuisine, int rating) {
        Pair<String, Integer> key = new Pair<>(cuisine, rating);
        Set<String> foods = cuisineRankFoods.get(key);
        foods.remove(food);
        if(foods.isEmpty()) {
            cuisineRanks.get(cuisine).remove(rating);
        }

    }

//    @Test()
    public void firstCase() {
        _2353FoodRatingSystem instance = new _2353FoodRatingSystem();

        instance.FoodRatings(
            new String[] {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
            new String[] { "korean", "japanese", "japanese", "greek", "japanese", "korean" },
            ArrayParser.parse("[9,12,8,15,14,7]")
        );

        assertEquals("kimchi", instance.highestRated("korean"));
        assertEquals("ramen", instance.highestRated("japanese"));

        instance.changeRating("sushi", 16);

        assertEquals("sushi", instance.highestRated("japanese"));

        instance.changeRating("ramen", 16);

        assertEquals("ramen", instance.highestRated("japanese"));
    }

//     @Test
    public void case36() {
        _2353FoodRatingSystem instance = new _2353FoodRatingSystem();

        instance.FoodRatings(
            new String[] { "emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"},
            new String[] { "snaxol","snaxol","snaxol","fajbervsj","fajbervsj" },
            ArrayParser.parse("[2,6,18,6,5]")
        );

        instance.changeRating("qnvseohnoe", 11);

        assertEquals("yhptazyko", instance.highestRated("fajbervsj"));

        instance.changeRating("emgqdbo", 3);
        instance.changeRating("jmvfxjohq", 9);
        instance.changeRating("emgqdbo", 14);

        assertEquals("yhptazyko", instance.highestRated("fajbervsj"));
        assertEquals("emgqdbo", instance.highestRated("snaxol"));
    }

    @Test
    public void case54() {
        _2353FoodRatingSystem instance = new _2353FoodRatingSystem();

        /**
         * [[["tjokfmxg",14],["waxlau"],["waxlau"],["tjokfmxg",4],["waxlau"],["mnij",18],["waxlau"]]
         */

        instance.FoodRatings(
            new String[] { "tjokfmxg","xmiuwozpmj","uqklk","mnij","iwntdyqxi","cduc","cm","mzwfjk"},
            new String[] { "waxlau","ldpiabqb","ldpiabqb","waxlau","ldpiabqb","waxlau","waxlau","waxlau" },
            ArrayParser.parse("[9,13,7,16,10,17,16,17]")
        );

        instance.changeRating("tjokfmxg", 19);

        assertEquals("tjokfmxg", instance.highestRated("waxlau"));

        instance.changeRating("uqklk", 7);

        assertEquals("tjokfmxg", instance.highestRated("waxlau"));
        assertEquals("tjokfmxg", instance.highestRated("waxlau"));

        instance.changeRating("tjokfmxg", 14);

        assertEquals("cduc", instance.highestRated("waxlau"));
        assertEquals("cduc", instance.highestRated("waxlau"));

        instance.changeRating("tjokfmxg", 14);

        assertEquals("cduc", instance.highestRated("waxlau"));

        instance.changeRating("mnij", 18);

        assertEquals("mnij", instance.highestRated("waxlau"));
    }

}
