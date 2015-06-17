package com.mr_faton.task2;

import com.mr_faton.task2.core.WayResolver;
import com.mr_faton.task2.model.City;
import com.mr_faton.task2.model.Direction;
import com.mr_faton.task2.model.Graph;
import com.mr_faton.utils.InputHelper;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mr_Faton on 15.06.2015.
 */
public class TransportationCost {
    private static List<City> cities = new LinkedList<>();
    private static List<Direction> directions = new LinkedList<>();

    public static void main(String[] args) {


        InputHelper inputHelper = new InputHelper();

        setUpCityList(inputHelper);
        setUpDirections(inputHelper);

        City sourceCity = getCityByName(inputHelper.getStringData("Please input source city name:"));
        City targetCity = getCityByName(inputHelper.getStringData("Please target source city name:"));
        inputHelper.closeInput();

        Graph graph = new Graph(cities, directions);
        WayResolver resolver = new WayResolver(graph);
        resolver.initiate(sourceCity);
        List<City> route = resolver.getPath(targetCity);

        printRoutePath(route);
        printRoutCost(targetCity, resolver);

    }

    private static void setUpCityList(InputHelper inputHelper) {
        final int citiesCount = inputHelper.getIntNumber("How many cities you wish to add?");

        System.out.println("Let's add cities!");
        for (int i = 0; i < citiesCount; i++) {
            final int cityID = inputHelper.getIntNumber("Input city ID:");
            final String cityName = inputHelper.getStringData("Input city name:");
            City city = new City(cityID, cityName);
            cities.add(city);
        }
    }

    private static void setUpDirections(InputHelper inputHelper) {
        String stopStr = "stop";
        System.out.println("Let's add directions between cities!\n" +
                "To stop the input process type \"" + stopStr + "\"");

        boolean loop = true;
        while (loop) {
            System.out.println("new direction");
            String source = "";
            City sourceCity = null;
            do {
                source = inputHelper.getStringData("input source city:");
                sourceCity = getCityByName(source);
                if (sourceCity == null) {
                    System.out.println("You have entered unknown city please try again");
                }
            } while (sourceCity == null && !source.equals(stopStr));

            String target = "";
            City targetCity = null;
            do {
                target = inputHelper.getStringData("input target city:");
                targetCity = getCityByName(target);
                if (targetCity == null) {
                    System.out.println("You have entered unknown city please try again");
                }
            } while (targetCity == null && !target.equals(stopStr));

            int cost = inputHelper.getIntNumber("input direction cost:");

            Direction direction = new Direction(sourceCity, targetCity, cost);
            directions.add(direction);

            if (source.equals(stopStr) || target.equals(stopStr)) {
                loop = false;
            }
        }




        Collection<String> rawDirections = inputHelper.getStringDataCollection("Please input source city, " +
                "destination city and cost separated by space,\ne.g.: Greenville Redville 3");

        for (String line : rawDirections) {
            String[] tokens = line.split(" ");
            if (tokens.length == 3) {
                String source = tokens[0];
                String target = tokens[1];
                int cost = Integer.valueOf(tokens[2]);
                City sourceCity = null;
                City targetCity = null;
                for (City city : cities) {
                    if (source.equals(city.getName())) {
                        sourceCity = city;
                    }
                    if (target.equals(city.getName())) {
                        targetCity = city;
                    }
                }
                if (sourceCity != null && targetCity != null) {
                    Direction direction = new Direction(sourceCity, targetCity, cost);
                    directions.add(direction);
                }
            }
        }
    }

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

    private static void printRoutePath(List<City> route) {
        String routeStr = "Your path is:\n";
        for (City city : route) {
            routeStr += city.getName() + " -> ";
        }
        String updatedRouteStr = routeStr.substring(0, routeStr.lastIndexOf(" -> "));
        System.out.println(updatedRouteStr);
    }

    private static void printRoutCost(City targetCity, WayResolver resolver) {
        int cost = resolver.getCost(targetCity);
        System.out.println("Your cost is: " + cost);
    }
}
