package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private List<Car> vehicles = new ArrayList<>();
    private Position lowerLeft = new Position(0, 5);
    private Position upperRight = new Position(5, 0);
    private MapVisualizer mapVisualizer;

    public RectangularMap(int width, int height) {
        this.upperRight = new Position(width, height);
        this.lowerLeft = new Position(0, 0);
        this.mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return position.smaller(upperRight) &&
                position.larger(lowerLeft) &&
                !isOccupied(position);
    }

    @Override
    public boolean place(Car car) {
        if (isOccupied(car.getPosition())) return false;
        vehicles.add(car);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int carCurrNum = 0;
        int carTotal = vehicles.size();
        for (MoveDirection direction : directions) {
            Car currentCar = vehicles.get(carCurrNum++);
            currentCar.move(direction);
            if (carCurrNum == carTotal) carCurrNum = 0;
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    @Override
    public Object objectAt(Position position) {
        for (Car vehicle : vehicles)
            if (vehicle.getPosition().equals(position)) return vehicle;
        return null;
    }

    @Override
    public String toString() {
        return this.mapVisualizer.draw(lowerLeft, upperRight);
    }

    public IWorldMap wzium(String[] args, Car[] cars) {
        MoveDirection[] directions = new OptionsParser().parse(args);
        for (Car car : cars) {
            this.place(car);
        }
        this.run(directions);
        System.out.println(this);
        return this;
    }
}
