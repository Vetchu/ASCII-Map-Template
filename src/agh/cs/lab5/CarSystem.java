package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class CarSystem {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionsParser().parse(args);
        List<HayStack> hays = new ArrayList<>();
        hays.add(new HayStack(new Position(-4,-4)));
        hays.add(new HayStack(new Position(7,7)));
        hays.add(new HayStack(new Position(3,6)));
        hays.add(new HayStack(new Position(2,0)));
        IWorldMap map = new UnboundedMap(hays);
        map.place(new Car(map));
        map.place(new Car(map,3,4));
        map.run(directions);
        System.out.println(map.toString());
    }
}
