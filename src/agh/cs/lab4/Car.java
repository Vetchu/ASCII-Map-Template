package agh.cs.lab4;

public class Car {
    private MapDirection direction = MapDirection.North;
    private Position position = new Position(2, 2);
    private IWorldMap map;

    public String toString() {
        //return direction.toString().substring(0,1);
        switch (direction) {
            case North:
                return "^";
            case South:
                return "v";
            case West:
                return "<";
            case East:
                return ">";
        }
        return null;
    }

    Position getPosition() {
        return position;
    }

    void move(MoveDirection direction) {
        Position moveVector = this.direction.getVector();
        switch (direction) {
            case Right:
                this.direction = this.direction.next();
                break;
            case Left:
                this.direction = this.direction.prev();
                break;
            case Backward:
                moveVector = moveVector.mult(-1);
            case Forward:
                Position temp = this.position.add(moveVector);
                if (map.canMoveTo(temp))
                    if (!this.map.isOccupied(temp))
                        this.position = temp;
                break;
            default:
        }
    }

    Car() {

    }

    Car(IWorldMap map) {
        this.map = map;
    }

    Car(IWorldMap map, int x, int y) {
        this.position = new Position(x, y);
        this.map = map;
    }

    public void wzium(String[] args) {
        MoveDirection[] moves = new OptionsParser().parse(args);
        for (MoveDirection move : moves) {
            move(move);
        }
    }

    public static void main(String[] args) {
        Car newCar = new Car();
        System.out.println(newCar.toString());
        MoveDirection[] moves = new OptionsParser().parse(args);
        for (MoveDirection tmp : moves) newCar.move(tmp);
        System.out.println(newCar.toString());
    }
}
