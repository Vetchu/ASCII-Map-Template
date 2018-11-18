package agh.cs.lab4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest {
    RectangularMap map=new RectangularMap(10,5);
    Car[] cars={new Car(map),new Car(map, 3,4)};

    @Before
    public void setUp(){
        map.wzium(new String[]{"f","b", "r", "l", "f", "f","r","r","f","f","f","f","f","f","f","f"},cars);
    }
    @Test
    public void RectangularMapTest() {
        assertEquals(cars[0].getPosition().toString(),"(2,0)");
        assertEquals(cars[1].getPosition().toString(),"(3,5)");
        assertEquals(cars[0].toString(),"v");
        assertEquals(cars[1].toString(),"^");
    }
    @Test
    public void isOccupiedTest(){
        assertTrue(map.isOccupied(new Position(2,0)));
        assertFalse(map.isOccupied(new Position(1,0)));

    }

}