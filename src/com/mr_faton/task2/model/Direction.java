package com.mr_faton.task2.model;

/**
 * Created by Mr_Faton on 15.06.2015.
 */
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
