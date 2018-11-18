package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    protected List<IMapElement> elements = new ArrayList<>();
    protected Position lowerLeft = new Position(0, 0);
    protected Position upperRight = new Position(0, 0);

    @Override
    public void run(MoveDirection[] directions) {
        int carTotal =0;
        for (IMapElement element : elements) {
            if (element instanceof Car) carTotal++;
        }
        int carI=0;
        for (int i = 0; i < directions.length; i++) {
            while (!(elements.get(carI % carTotal) instanceof Car))carI++;
            Car currentCar = (Car) elements.get(carI++ % carTotal);
            currentCar.move(directions[i]);
        }
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    public boolean place(Car car) {
        for (IMapElement vehicle : elements)
            if (vehicle.getPosition().equals(car.getPosition())) return false;
        elements.add(car);
        return true;
    }

    @Override
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }


    public Object objectAt(Position position) {
        for (IMapElement vehicle : elements)
            if (vehicle.getPosition().equals(position)) return vehicle;
        return null;
    }

    public AbstractWorldMap wzium(String args[], Car[] cars) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        for (Car car : cars) {
            this.place(car);
        }
        this.run(directions);
        System.out.println(this);
        return this;
    }

    public String toString() {
        return new MapVisualizer().dump(this, lowerLeft, upperRight);
    }
}
