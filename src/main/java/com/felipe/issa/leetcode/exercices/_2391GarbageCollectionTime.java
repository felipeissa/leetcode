package com.felipe.issa.leetcode.exercices;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.Assert.assertEquals;

public class _2391GarbageCollectionTime {

    /**
     * https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/
     */
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<String, Integer> garbageCount = new HashMap<>();
        Map<String, Integer> lastPosition = new HashMap<>();
        Map<Integer, Integer> timeToHouse = new HashMap<>();

        int timeToCurrentHouse = 0;
        for (int i = 0; i < travel.length; i++) {
            timeToCurrentHouse += travel[i];
            timeToHouse.put(i, timeToCurrentHouse);
        }

        for (int i = 0; i < garbage.length; i++) {
            String houseGarbage = garbage[i];
            BiConsumer<String, String> counter = (String type, String garbageFound) -> {
                int currentSize = garbageCount.getOrDefault(type, 0);
                currentSize += getGarbageCount(garbageFound, type);
                garbageCount.put(type, currentSize);
            };

            counter.accept("M", houseGarbage);
            counter.accept("P", houseGarbage);
            counter.accept("G", houseGarbage);

            if (houseGarbage.contains("M")) lastPosition.put("M", i);
            if (houseGarbage.contains("P")) lastPosition.put("P", i);
            if (houseGarbage.contains("G")) lastPosition.put("G", i);

        }


        int time = garbageCount.getOrDefault("M", 0);
        time += lastPosition.getOrDefault("M", 0) == 0 ? 0 : timeToHouse.get(lastPosition.get("M") - 1);

        time += garbageCount.getOrDefault("P", 0);
        time += lastPosition.getOrDefault("P", 0) == 0 ? 0 : timeToHouse.get(lastPosition.get("P") - 1);

        time += garbageCount.getOrDefault("G", 0);
        time += lastPosition.getOrDefault("G", 0) == 0 ? 0 : timeToHouse.get(lastPosition.get("G") - 1);


        return time;
    }

    public int getGarbageCount(String houseGarbage, String garbageType) {
        int garbageIndex = houseGarbage.indexOf(garbageType);
        int count = 0;
        while (garbageIndex != -1) {
            count += 1;
            garbageIndex = houseGarbage.indexOf(garbageType, garbageIndex + 1);
        }

        return count;
    }


    public int BruteForce(String[] garbage, int[] travel) {
        int time = getGarbageTime(garbage, travel, "P");
        time += getGarbageTime(garbage, travel, "G");
        time += getGarbageTime(garbage, travel, "M");

        return time;
    }

    private int getGarbageTime(String[] garbage, int[] travel, String garbageType) {
        int currentPlace = 0;
        int time = 0;
        for (int houseIndex = 0; houseIndex < garbage.length; houseIndex++) {
            String houseGarbage = garbage[houseIndex];
            int garbageIndex = houseGarbage.indexOf(garbageType);
            if (garbageIndex >= 0) {
                while (currentPlace < houseIndex) {
                    time += travel[currentPlace];
                    currentPlace++;
                }
                while (garbageIndex != -1) {
                    time += 1;
                    garbageIndex = houseGarbage.indexOf(garbageType, garbageIndex + 1);
                }
            }
        }

        return time;
    }

    @Test
    public void firstCase() {
        int output = new _2391GarbageCollectionTime().garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3});
        ;
        assertEquals(21, output);
    }

    @Test
    public void secondCase() {
        int output = new _2391GarbageCollectionTime().garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10});
        ;
        assertEquals(37, output);
    }
}
