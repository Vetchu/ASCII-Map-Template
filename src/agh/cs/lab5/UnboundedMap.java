package agh.cs.lab5;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    UnboundedMap(List<HayStack> hays){
        this.hays=hays;
    }
    private List<HayStack> hays;

    @Override
    public boolean canMoveTo(Position position) {
        for (Car vehicle : vehicles)
            if (vehicle.getPosition().equals(position)) return false;
        for (HayStack hay:hays)
            if(hay.getPosition().equals(position)) return false;
        return true;
    }

    @Override
    public boolean place(Car car) {
        for (Car vehicle : vehicles)
            if(vehicle.getPosition().equals(car.getPosition())) return false;
        for (HayStack hay:hays)
            if(hay.getPosition().equals(car.getPosition())) return false;

        vehicles.add(car);
        return true;
    }


    @Override
    public boolean isOccupied(Position position) {
        for (Car vehicle : vehicles)
            if (vehicle.getPosition().equals(position)) return true;
        for (HayStack hay:hays)
            if(hay.getPosition().equals(position)) return true;
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        for (Car vehicle : vehicles)
            if (vehicle.getPosition().equals(position)) return vehicle;
        for (HayStack hay:hays)
            if(hay.getPosition().equals(position)) return hay;
        return null;
    }

    @Override
    public String toString() {
        Position min,max;
        min=max=vehicles.get(0).getPosition();
        for (Car vehicle : vehicles) {
            if (vehicle.getPosition().smaller(min)) min =vehicle.getPosition();
            if (vehicle.getPosition().larger(max)) max =vehicle.getPosition();
        }
        for (HayStack hay:hays) {
            if (hay.getPosition().smaller(min)) min =hay.getPosition();
            if (hay.getPosition().larger(max)) max =hay.getPosition();
        }
        return new MapVisualizer().dump(this,min,max);
    }
}
