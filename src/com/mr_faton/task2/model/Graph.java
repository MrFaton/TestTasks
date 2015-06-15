package com.mr_faton.task2.model;

import java.util.List;

/**
 * Created by Mr_Faton on 15.06.2015.
 */
public class Graph {
    private final List<City> cities;
    private final List<Direction> directions;

    public Graph(List<City> cities, List<Direction> directions) {
        this.cities = cities;
        this.directions = directions;
    }

    public List<City> getCities() {
        return cities;
    }

    public List<Direction> getDirections() {
        return directions;
    }
}
