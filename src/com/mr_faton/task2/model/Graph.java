package com.mr_faton.task2.model;

import java.util.List;

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
/*
This bean contains all added cities and all added directions between cities
 */