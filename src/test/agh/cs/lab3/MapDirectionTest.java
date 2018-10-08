package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapDirectionTest {
    @Test
    public void toStringTest() {
        assertEquals("West=Zachód", agh.cs.lab2.MapDirection.West.toString(), "Zachód");
        assertEquals("East=Wschód", agh.cs.lab2.MapDirection.East.toString(), "Wschód");
        assertEquals("North=Północ", agh.cs.lab2.MapDirection.North.toString(), "Północ");
        assertEquals("South=Południe", agh.cs.lab2.MapDirection.South.toString(), "Południe");
    }

    @Test
    public void nextTest() {
        assertEquals("Zachód na Północ", agh.cs.lab2.MapDirection.West.next(), agh.cs.lab2.MapDirection.North);
        assertEquals("Wschód na Południe", agh.cs.lab2.MapDirection.East.next(), agh.cs.lab2.MapDirection.South);
    }

    @Test
    public void previousTest() {
        assertEquals("Północ na Zachód", agh.cs.lab2.MapDirection.North.next(), agh.cs.lab2.MapDirection.West);
        assertEquals("Południe na Wschód", agh.cs.lab2.MapDirection.South.next(), MapDirection.East);
    }
}