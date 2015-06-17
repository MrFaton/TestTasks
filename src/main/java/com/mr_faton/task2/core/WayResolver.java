package com.mr_faton.task2.core;

import com.mr_faton.task2.model.City;
import com.mr_faton.task2.model.Direction;
import com.mr_faton.task2.model.Graph;

import java.util.*;

public class WayResolver {
    private final List<City> cities;//all cities
    private final List<Direction> directions;//all directions between cities
    private Set<City> resolvedCities;//handled cities (or vertexes in Dijkstra's algorithm)
    private Set<City> unResolvedCities;//unhandled cities
    private Map<City, City> predecessors;//cities predecessors from start to target city
    private Map<City, Integer> distance;//the cost to each city from the source city

    public WayResolver(Graph graph) {
        //set up cities and directions
        cities = new ArrayList<>(graph.getCities());
        directions = new ArrayList<>(graph.getDirections());
    }

    //this method sets the source city (the start city)
    public void initiate(City source) {
        resolvedCities = new HashSet<>();
        unResolvedCities = new HashSet<>();
        predecessors = new HashMap<>();
        distance = new HashMap<>();
        //set distance (cost) to source (start) city equals zero
        distance.put(source, 0);
        //put source city to unhandled cities
        unResolvedCities.add(source);
        while (unResolvedCities.size() > 0) {
            //resolve source city (usually it's our start city)
            City city = getMinimum(unResolvedCities);
            //put this neighbor to handled cities
            resolvedCities.add(city);
            //remove this neighbor from unhandled cities
            unResolvedCities.remove(city);
            //evaluate minimal distance (costs) to every city
            findMinimalDistance(city);
        }
    }

    //return path from source city to destination city
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

    public int getCost(City destCity) {
        return distance.get(destCity);
    }

    //service methods
    //evaluate minimal distance (costs) to every city
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

    //get distance (cost) between two cities
    private int getDistance(City sourceCity, City destCity) {
        for (Direction direction : directions) {
            if (direction.getSource().equals(sourceCity) && direction.getDestination().equals(destCity)) {
                return direction.getCost();
            }
        }
        throw new RuntimeException("Error");
    }

    //get shortest cost based on distance
    private int getShortestDistance(City destCity) {
        Integer cost = distance.get(destCity);
        if (cost == null) {
            return Integer.MAX_VALUE;
        }
        return cost;
    }

    //find all neighbors of the city
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

    //return nearest neighbor
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
This class choose the cheapest way between two cities. It's implements Dijkstra's algorithm.
 */