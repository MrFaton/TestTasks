package task2;

import com.mr_faton.task2.core.WayResolver;
import com.mr_faton.task2.model.City;
import com.mr_faton.task2.model.Direction;
import com.mr_faton.task2.model.Graph;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TestWayResolver {
    @Test
    public void testWR() {
        //create lists
        List<City> cities = new ArrayList<>();
        List<Direction> directions = new ArrayList<>();

        //create cities
        City greenville = new City(1, "Greenville");
        City blueville = new City(2, "Blueville");
        City redville = new City(3, "Redville");
        City orangeville = new City(4, "Orangeville");

        //add cities to list
        cities.add(greenville);
        cities.add(blueville);
        cities.add(redville);
        cities.add(orangeville);

        //create directions

        //direction for Greenville
        Direction greenvilleBlueVilleDirection = new Direction(greenville, blueville, 2);
        Direction greenvilleRedVilleDirection = new Direction(greenville, redville, 5);
        //direction for Blueville
        Direction bluevilleGreenvilleDirection = new Direction(blueville, greenville, 2);
        Direction bluevilleRedvilleDirection = new Direction(blueville, redville, 1);
        Direction bluevilleOrangevilleDirection = new Direction(blueville, orangeville, 5);
        //direction for Redville
        Direction redvilleGreenvilleDirection = new Direction(redville, greenville, 5);
        Direction redvilleBluevilleDirection = new Direction(redville, blueville, 1);
        Direction redvilleOrangevilleDirection = new Direction(redville, orangeville, 1);
        //direction for Redville
        Direction orangevilleBluevilleDirection = new Direction(orangeville, blueville, 5);
        Direction orangevilleRedvilleDirection = new Direction(orangeville, redville, 1);

        //add directions to list
        directions.add(greenvilleBlueVilleDirection);
        directions.add(greenvilleRedVilleDirection);
        directions.add(bluevilleGreenvilleDirection);
        directions.add(bluevilleRedvilleDirection);
        directions.add(bluevilleOrangevilleDirection);
        directions.add(redvilleGreenvilleDirection);
        directions.add(redvilleBluevilleDirection);
        directions.add(redvilleOrangevilleDirection);
        directions.add(orangevilleBluevilleDirection);
        directions.add(orangevilleRedvilleDirection);

        //create graph
        Graph graph = new Graph(cities, directions);
        //create WayResolver
        WayResolver resolver = new WayResolver(graph);
        //set up sourse city
        resolver.initiate(greenville);
        //get route to the destination city
        List<City> route = resolver.getPath(orangeville);

        assertNotNull(route);

        //get cost to destination city
        int cost = resolver.getCost(orangeville);

        //check asserts

        assertEquals("Cost not equals", 4, cost);

        assertEquals("Route Greenville not equals", greenville.getName(), route.get(0).getName());
        assertEquals("Route Bleuville not equals", blueville.getName(), route.get(1).getName());
        assertEquals("Route Redville not equals", redville.getName(), route.get(2).getName());
        assertEquals("Route Orangeville not equals", orangeville.getName(), route.get(3).getName());
    }

}
