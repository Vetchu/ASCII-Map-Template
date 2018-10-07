package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    RectangularMap(int width, int height){
        this.upperRight=new Position(width,height);
        this.lowerLeft=new Position(0,0);
    }

    private List<Car> vehicles=new ArrayList<>();
    private Position lowerLeft;
    private Position upperRight;

    @Override
    public boolean canMoveTo(Position position) {
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
    public boolean isOccupied(Position position) {
        for (Car vehicle : vehicles)
            if (vehicle.getPosition().equals(position)) return true;
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        for (Car vehicle : vehicles)
            if (vehicle.getPosition().equals(position)) return vehicle;
        return null;
    }

    @Override
    public String toString() {
        return new MapVisualizer().dump(this,lowerLeft,upperRight);
    }
}
