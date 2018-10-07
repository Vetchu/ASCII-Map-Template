package test;

import agh.cs.lab2.MapDirection;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapDirectionTest {
    @Test
    public void MapDirectionTest() {
        // assert statements

        assertEquals("West=Zachód", MapDirection.West.toString(), "Zachód");
        assertEquals("East=Wschód", MapDirection.East.toString(), "Wschód");
        assertEquals("North=Północ", MapDirection.North.toString(), "Północ");
        assertEquals("South=Południe", MapDirection.South.toString(), "Południe");
    }
//TODO: Reszta Testów

}