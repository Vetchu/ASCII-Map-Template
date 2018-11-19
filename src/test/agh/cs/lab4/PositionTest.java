package agh.cs.lab4;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    Position A = new Position(1, 2);

    @Test
    public void toStringTest() {
        assertEquals("(3,4)", new Position(3, 4).toString(), "(3,4)");
        assertEquals("(5,-1)", new Position(5, -1).toString(), "(5,-1)");
    }

    @Test
    public void smallerTest() {
        assertTrue("Pozycja 3,4 > 1,2", A.smaller(new Position(3, 4)));
        assertTrue("Pozycja 1,2 <=1,2", A.smaller(new Position(1, 2)));
        assertFalse("Pozycja 0,1 <=1,2", A.smaller(new Position(1, 1)));
    }

    @Test
    public void largerTest() {
        assertFalse("Pozycja 3,4 > 1,2", A.larger(new Position(3, 4)));
        assertTrue("Pozycja 1,2 <=1,2", A.larger(new Position(1, 2)));
        assertTrue("Pozycja 0,1 <=1,2", A.larger(new Position(1, 1)));
    }

    @Test
    public void lowerLeftTest() {
        assertEquals("Lewa Dolna Pozycja 3,3 i 1,2-> 1,2", A.lowerLeft(new Position(3, 3)), new Position(1, 2));
        assertEquals("Lewa Dolna Pozycja 2,1 i 1,2-> 1,1", A.lowerLeft(new Position(2, 1)), new Position(1, 1));
    }

    @Test
    public void upperRightTest() {
        assertEquals("Prawa Górna Pozycja 3,3 i 1,2-> 3,3", A.upperRight(new Position(3, 3)), new Position(3, 3));
        assertEquals("Prawa Górna Pozycja 2,1 i 1,2-> 2,2", A.upperRight(new Position(2, 1)), new Position(2, 2));
    }

    @Test
    public void add() {
        assertEquals("Pozycja plus 3,3 i 1,2-> 4,5", A.add(new Position(3, 3)), new Position(4, 5));
        assertEquals("Pozycja plus 2,1 i 1,2-> 3,3", A.add(new Position(2, 1)), new Position(3, 3));
    }
}