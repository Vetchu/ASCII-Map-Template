package agh.cs.lab6;

public class RectangularMap extends AbstractWorldMap {
    RectangularMap(int width, int height) {
        this.upperRight = new Position(width, height);
        this.lowerLeft = new Position(0, 0);
    }



    public static void main(String[] args) {
        RectangularMap map = new RectangularMap(10, 5);
        Car[] cars = {new Car(map), new Car(map, 3, 4)};

        map.wzium(new String[]{
                "f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"
        }
                ,cars);
    }


}

