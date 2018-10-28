package agh.cs.lab3;

public class Car {
    private MapDirection direction = MapDirection.North;
    private Position position = new Position(2, 2);
    private static final Position LOWER_BOUND = new Position(0,0);
    private static final Position UPPER_BOUND = new Position(4,4);


    public String toString() {
        return "Kierunek: " + direction + ", Pozycja: " + position.toString();
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
                moveVector=moveVector.mult(-1);
            case Forward:
                Position temp = this.position.add(moveVector);
                if (temp.larger(LOWER_BOUND) && temp.smaller(UPPER_BOUND))
                    this.position = temp;
                break;
            default:
        }
    }

    public void wzium(String[] args){
            MoveDirection[] moves=new OptionsParser().parse(args);
            for(MoveDirection move : moves){
                move(move);
            }
    }

    public static void main(String[] args) {
        Car newCar = new Car();
        System.out.println(newCar);

        newCar.move(MoveDirection.Left);
        newCar.move(MoveDirection.Backward);
        newCar.move(MoveDirection.Backward);
        newCar.move(MoveDirection.Backward);

        MoveDirection[] moves = new OptionsParser().parse(args);
        for (MoveDirection tmp : moves) newCar.move(tmp);
        System.out.println(newCar);
    }
}
