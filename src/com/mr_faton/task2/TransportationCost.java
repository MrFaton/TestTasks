package com.mr_faton.task2;

import com.mr_faton.task2.model.City;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Mr_Faton on 15.06.2015.
 */
public class TransportationCost {
    public static void main(String[] args) {
        int pairsCount = 2;

        City gdansk = new City(1, "gdansk", 2);
        City bydgoszcz = new City(2, "bydgoszcz", 3);
        City torun = new City(3, "torun", 3);
        City warszawa = new City(4, "warszawa", 2);

        Map<Integer, Integer> gdanskNeighboursMap = new LinkedHashMap<>();
        gdanskNeighboursMap.put(bydgoszcz.getId(), 1);
        gdanskNeighboursMap.put(torun.getId(), 3);
        gdansk.setNeighboursMap(gdanskNeighboursMap);

        Map<Integer, Integer> bydgoszczNeighboursMap = new LinkedHashMap<>();
        bydgoszczNeighboursMap.put(gdansk.getId(), 1);
        bydgoszczNeighboursMap.put(torun.getId(), 1);
        bydgoszczNeighboursMap.put(warszawa.getId(), 4);
        bydgoszcz.setNeighboursMap(bydgoszczNeighboursMap);

        Map<Integer, Integer> torunNeighboursMap = new LinkedHashMap<>();
        torunNeighboursMap.put(gdansk.getId(), 3);
        torunNeighboursMap.put(bydgoszcz.getId(), 1);
        torunNeighboursMap.put(warszawa.getId(), 1);
        torun.setNeighboursMap(torunNeighboursMap);

        Map<Integer, Integer> warszawaNeighboursMap = new LinkedHashMap<>();
        warszawaNeighboursMap.put(bydgoszcz.getId(), 4);
        warszawaNeighboursMap.put(torun.getId(), 1);
        warszawa.setNeighboursMap(warszawaNeighboursMap);


        Map<City, City> direction = new LinkedHashMap<>();
        direction.put(gdansk, warszawa);
        direction.put(bydgoszcz, warszawa);
    }
}
