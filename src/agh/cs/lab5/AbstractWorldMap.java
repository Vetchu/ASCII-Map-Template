package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    protected List<Car> vehicles=new ArrayList<>();

    @Override
    public void run(MoveDirection[] directions) {
        int carTotal=vehicles.size();
        for (int i=0;i<directions.length;i++) {
            Car currentCar=vehicles.get(i%carTotal);
            currentCar.move(directions[i]);
        }
    }
}
