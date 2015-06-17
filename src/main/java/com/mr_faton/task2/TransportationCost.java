package com.mr_faton.task2;

import com.mr_faton.task2.core.WayResolver;
import com.mr_faton.task2.model.City;
import com.mr_faton.task2.model.Direction;
import com.mr_faton.task2.model.Graph;
import com.mr_faton.utils.InputHelper;

import java.util.LinkedList;
import java.util.List;

public class TransportationCost {
    private static List<City> cities;
    private static List<Direction> directions;

    public static void main(String[] args) {
        //create lists
        cities = new LinkedList<>();
        directions = new LinkedList<>();

        //create InputHealper
        InputHelper inputHelper = new InputHelper();

        //fill lists
        setUpCityList(inputHelper);
        setUpDirections(inputHelper);

        //get start city
        City sourceCity = getCityByName(inputHelper.getStringData("Please input source city name:"));
        //get destination city
        City targetCity = getCityByName(inputHelper.getStringData("Please input target city name:"));
        //close acanner in InputHelper
        inputHelper.closeInput();

        //build graph
        Graph graph = new Graph(cities, directions);
        //build WayResolver
        WayResolver resolver = new WayResolver(graph);
        //set up source (start) city
        resolver.initiate(sourceCity);
        //get path to target city
        List<City> route = resolver.getPath(targetCity);

        //print all path
        printRoutePath(route);
        //print path cost
        printRoutCost(targetCity, resolver);

    }

    //method fills the cities list
    private static void setUpCityList(InputHelper inputHelper) {
        //invite to input number of cities which will be added to list
        final int citiesCount = inputHelper.getIntNumber("How many cities you wish to add?");
        //create the city and add it to list
        System.out.println("Let's add cities!");
        for (int i = 0; i < citiesCount; i++) {
            final int cityID = inputHelper.getIntNumber("Input city ID:");
            final String cityName = inputHelper.getStringData("Input city name:");
            City city = new City(cityID, cityName);
            cities.add(city);
        }
    }

    //method fills the directions list
    private static void setUpDirections(InputHelper inputHelper) {
        System.out.println("Let's add directions between cities!");

        boolean loop = true;
        while (loop) {
            System.out.println("Create new direction");
            String source;
            City sourceCity = null;
            //here user must input exist city name (a name from cities list only)
            while (sourceCity == null) {
                source = inputHelper.getStringData("input source city name:");
                sourceCity = getCityByName(source);
                if (sourceCity == null) {
                    System.out.println("You have entered unknown city please try again");
                }
            }
            //here user must input exist city name (a name from cities list only)
            String target;
            City targetCity = null;
            while (targetCity == null) {
                target = inputHelper.getStringData("input target city name:");
                targetCity = getCityByName(target);
                if (targetCity == null) {
                    System.out.println("You have entered unknown city please try again");
                }
            }
            //cost between two cities
            int cost = inputHelper.getIntNumber("input direction cost:");
            //create direction and put into list
            Direction direction = new Direction(sourceCity, targetCity, cost);
            directions.add(direction);
            //ask user to add another direction
            String answer = inputHelper.getStringData("Create new direction? y/n");
            if (!answer.equals("y")) {
                loop = false;
            }
        }
    }

    //method takes city name string and returns the city object if city with given name exist
    private static City getCityByName(String cityName) {
        City resultCity = null;
        for (City city : cities) {
            if (cityName.equals(city.getName())) {
                resultCity = city;
                break;
            }
        }
        return resultCity;
    }

    //just print path list
    private static void printRoutePath(List<City> route) {
        String routeStr = "Your path is:\n";
        for (City city : route) {
            routeStr += city.getName() + " -> ";
        }
        String updatedRouteStr = routeStr.substring(0, routeStr.lastIndexOf(" -> "));
        System.out.println(updatedRouteStr);
    }

    //just print path cost
    private static void printRoutCost(City targetCity, WayResolver resolver) {
        int cost = resolver.getCost(targetCity);
        System.out.println("Your cost is: " + cost);
    }
}
