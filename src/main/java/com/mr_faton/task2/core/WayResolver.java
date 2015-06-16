package com.mr_faton.task2.core;

import com.mr_faton.task2.model.City;
import com.mr_faton.task2.model.Direction;
import com.mr_faton.task2.model.Graph;

import java.util.*;

public class WayResolver {
    private final List<City> cities;//all cities
    private final List<Direction> directions;//all directions between cities
    private Set<City> resolvedCities;
    private Set<City> unResolvedCities;
    private Map<City, City> predecessors;
    private Map<City, Integer> distance;

    public WayResolver(Graph graph) {
        cities = new ArrayList<>(graph.getCities());
        directions = new ArrayList<>(graph.getDirections());
    }

    //this method sets the source city (the leaving city)
    public void initiate(City source) {
        resolvedCities = new HashSet<>();
        unResolvedCities = new HashSet<>();
        predecessors = new HashMap<>();
        distance = new HashMap<>();

        distance.put(source, 0);
        unResolvedCities.add(source);
        while (unResolvedCities.size() > 0) {
            City city = getMinimum(unResolvedCities);
            resolvedCities.add(city);
            unResolvedCities.remove(city);
            findMinimalDistance(city);
        }
    }

    public List<City> getPath(City destCity) {
        List<City> path = new LinkedList<>();
        City step = destCity;

        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }

    private void findMinimalDistance(City city) {
        List<City> neighborCites = getNeighbors(city);
        for (City destCity : neighborCites) {
            if (getShortestDistance(destCity) > getShortestDistance(city) + getDistance(city, destCity)) {
                distance.put(destCity, getShortestDistance(city) + getDistance(city, destCity));
                predecessors.put(destCity, city);
                unResolvedCities.add(destCity);
            }
        }
    }

    private int getDistance(City sourceCity, City destCity) {
        for (Direction direction : directions) {
            if (direction.getSource().equals(sourceCity) && direction.getDestination().equals(destCity)) {
                return direction.getCost();
            }
        }
        throw new RuntimeException("Error");
    }

    private int getShortestDistance(City destCity) {
        Integer cost = distance.get(destCity);
        if (cost == null) {
            return Integer.MAX_VALUE;
        }
        return cost;
    }

    private List<City> getNeighbors(City city) {
        List<City> neighbors = new ArrayList<>();
        for (Direction direction : directions) {
            if (direction.getSource().equals(city) && !isResolved(direction.getDestination())) {
                neighbors.add(direction.getDestination());
            }
        }
        return neighbors;
    }

    private boolean isResolved(City destCity) {
        return resolvedCities.contains(destCity);
    }

    private City getMinimum(Set<City> unResolvedCities) {
        City nearestCity = null;
        for (City city : unResolvedCities) {
            if (nearestCity == null) {
                nearestCity = city;
            } else {
                if (getShortestDistance(city) < getShortestDistance(nearestCity)) {
                    nearestCity = city;
                }
            }
        }
        return nearestCity;
    }
}
/*
This class choose the cheapest way between two cities. It's implements Dijkstra’s algorithm.
 */