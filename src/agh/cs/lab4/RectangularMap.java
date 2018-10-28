package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    RectangularMap(int width, int height){
        this.upperRight=new Position(width,height);
        this.lowerLeft=new Position(0,0);
    }
    private List<Car> vehicles=new ArrayList<>();
    private Position lowerLeft=new Position(0,5);
    private Position upperRight=new Position(5,0);

    @Override
    public boolean canMoveTo(Position position) {
        if(!position.smaller(upperRight)||!position.larger(lowerLeft)) return false;
        for (Car vehicle : vehicles)
            if (vehicle.getPosition().equals(position)) return false;
        return true;
    }

    @Override
    public boolean place(Car car) {
        for (Car vehicle : vehicles)
            if(vehicle.getPosition().equals(car.getPosition())) return false;
        vehicles.add(car);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int carCurrNum=0;
        int carTotal=vehicles.size();
        for (MoveDirection direction : directions) {
            System.out.println(new MapVisualizer().dump(this, this.lowerLeft, this.upperRight));
            Car currentCar=vehicles.get(carCurrNum++);
            currentCar.move(direction);
            if(carCurrNum==carTotal) carCurrNum=0;
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        return !canMoveTo(position);
    }

    @Override
    public Object objectAt(Position position) {
        for (Car vehicle : vehicles)
            if (vehicle.getPosition().equals(position)) return vehicle;
        return null;
    }

    @Override
    public String toString() {
        return new MapVisualizer().dump(this,this.lowerLeft,this.upperRight);
    }
}
