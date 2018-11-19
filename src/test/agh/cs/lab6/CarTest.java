package agh.cs.lab6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {
    //TODO: implement integration tests for all classes (OptionsParsers too)
    String[] args = {"f", "rs", "f", "f", "b"};
    Car car = new Car();

    @Test
    public void carArrayParseTest() {
        car.wzium(args);
        assertEquals(car.toString(),"Kierunek: Północ, Pozycja: (2,3)");
        Car car = new Car();
        car.wzium(new String[]{"f","brum","zium","f","dpkg","heh"});
        assertEquals(car.toString(),"Kierunek: Północ, Pozycja: (2,4)");
    }

    @Test
    public void CarTest() {
        car.move(MoveDirection.Left);
        car.move(MoveDirection.Backward);
        car.move(MoveDirection.Backward);
        car.move(MoveDirection.Backward);
        car.move(MoveDirection.Backward);
        assertEquals(car.toString(),"Kierunek: Zachód, Pozycja: (4,2)");
    }
}
