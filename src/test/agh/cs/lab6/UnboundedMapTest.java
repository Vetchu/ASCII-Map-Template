package agh.cs.lab6;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnboundedMapTest {
    UnboundedMap map=new UnboundedMap(null);
    Car[] cars={new Car(map),new Car(map, 3,4)};

    @Before
    public void setUp(){
        map.wzium(new String[]{"f","b", "r", "l", "f", "f","r","r","f","f","f","f","f","f","f","f"},cars);
    }
    @Test
    public void UnboundedMapTest() {
        assertEquals(cars[0].getPosition().toString(),"(2,-1)");
        assertEquals(cars[1].getPosition().toString(),"(3,6)");
        assertEquals(cars[0].toString(),"v");
        assertEquals(cars[1].toString(),"^");
    }
    @Test
    public void isOccupiedTest(){
        assertTrue(map.isOccupied(new Position(2,-1)));
        assertFalse(map.isOccupied(new Position(1,0)));

    }
}