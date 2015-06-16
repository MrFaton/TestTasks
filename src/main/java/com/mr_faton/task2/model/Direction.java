package com.mr_faton.task2.model;

public class Direction {
    private final City source;
    private final City destination;
    private final int cost;

    public Direction(City source, City destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    public City getSource() {
        return source;
    }

    public City getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return source + " - " + destination;
    }
}
/*
This bean represents direction (connection or road) between two cities.
Note: if we have two cities and the have double direction connection, we must to create two directions:
1-st direction: City1 -> City2
2-nd direction: City2 -> City1
 */