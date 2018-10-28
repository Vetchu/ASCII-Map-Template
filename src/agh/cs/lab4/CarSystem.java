package agh.cs.lab4;

public class CarSystem {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Car(map));
        map.place(new Car(map,3,4));
        map.run(directions);
        System.out.println(map);
    }
}
