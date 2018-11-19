package agh.cs.lab7;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap{

    protected Map<Position,IMapElement> elements = new HashMap<>();
    protected Position lowerLeft = new Position(0, 0);
    protected Position upperRight = new Position(0, 0);

    @Override
    public void run(MoveDirection[] directions) {
        IMapElement[] values= elements.values().toArray(new IMapElement[elements.size()]);
        List<Car> cars=new ArrayList<>();

        for (IMapElement element : values) {
            if (element instanceof Car) cars.add((Car)element);
        }
        int carTotal =cars.size();

        for (int i = 0; i < directions.length; i++) {
            Car temp=(Car)elements.get(cars.get(i % carTotal).getPosition());
            Position beforeMove=temp.getPosition();
            temp.move(directions[i]);
            temp.positionChanged(beforeMove);
        }
    }

    @Override
    public boolean canMoveTo(Position position) {
        return position.smaller(upperRight) &&
                position.larger(lowerLeft) &&
                !isOccupied(position);
    }


    public boolean place(Car car) {
        if(elements.get(car.getPosition())!=null)
            throw new IllegalArgumentException(car.getPosition() + " is already taken while placing a new car.");
        elements.put(car.getPosition(),car);
        return true;
    }

    @Override
    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    public Object objectAt(Position position) {
        return elements.get(position);
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
    public boolean positionChanged(Position oldPosition, Position newPosition){
        IMapElement car=elements.get(oldPosition);
        elements.remove(oldPosition);
        elements.put(newPosition,car);
        return false;
    }

    public String toString() {
        return new MapVisualizer().dump(this, lowerLeft, upperRight);
    }
}
