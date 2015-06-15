package com.mr_faton.task2;

import com.mr_faton.task2.core.WayResolver;
import com.mr_faton.task2.model.City;
import com.mr_faton.task2.model.Direction;
import com.mr_faton.task2.model.Graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mr_Faton on 15.06.2015.
 */
public class TransportationCost {
    public static void main(String[] args) {
        List<City> cities = new LinkedList<>();
        List<Direction> directions = new LinkedList<>();

        City gdansk = new City(1, "gdansk");
        City bydgoszcz = new City(2, "bydgoszcz");
        City torun = new City(3, "torun");
        City warszawa = new City(4, "warszawa");

        cities.add(gdansk);
        cities.add(bydgoszcz);
        cities.add(torun);
        cities.add(warszawa);

        Direction directionGdanskBydgoszcz = new Direction(gdansk, bydgoszcz, 2);
        Direction directionGdanskTorun = new Direction(gdansk, torun, 5);
        directions.add(directionGdanskBydgoszcz);
        directions.add(directionGdanskTorun);

        Direction directionBydgoszczGdansk = new Direction(bydgoszcz, gdansk, 2);
        Direction directionBydgoszczTorun = new Direction(bydgoszcz, torun, 6);
        Direction directionBydgoszczWarszawa = new Direction(bydgoszcz, warszawa, 5);
        directions.add(directionBydgoszczGdansk);
        directions.add(directionBydgoszczTorun);
        directions.add(directionBydgoszczWarszawa);

        Direction directionTorunGdansk = new Direction(torun, gdansk, 5);
        Direction directionTorunBydgoszcz = new Direction(torun, bydgoszcz, 6);
        Direction directionTorunWarszawa = new Direction(torun, warszawa, 1);
        directions.add(directionTorunGdansk);
        directions.add(directionTorunBydgoszcz);
        directions.add(directionTorunWarszawa);

        Direction directionWarszawaBydgoszcz = new Direction(warszawa, bydgoszcz, 5);
        Direction directionWarszawaTorun = new Direction(warszawa, torun, 1);
        directions.add(directionWarszawaBydgoszcz);
        directions.add(directionWarszawaTorun);

        Graph graph = new Graph(cities, directions);
        WayResolver resolver = new WayResolver(graph);
        resolver.initiate(cities.get(0));
        List<City> steps = resolver.getPath(cities.get(3));

        System.out.println(steps);
        System.out.println("****************************************");
    }
}
