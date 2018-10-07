package agh.cs.lab3;

import java.awt.*;

public class Car {
    private MapDirection carDir = MapDirection.North;
    private Position carPosition = new Position(2, 2);

    public String toString() {
        return "Kierunek: " + carDir + ", Pozycja: " + carPosition.toString();
    }

    private void move(MoveDirection direction) {
        switch (direction) {
            case Forward:
            case Backward:
                int a = (direction == MoveDirection.Forward) ? 1 : -1;
                Position topLeft = new Position(1, 1);
                Position bottomRight = new Position(3, 3);
                Position temp=this.carPosition;
                switch (this.carDir) {
                    case North:
                        temp = this.carPosition.add(new Position(0, a));
                        break;
                    case South:
                        temp = this.carPosition.add(new Position(0, -a));
                        break;
                    case East:
                        temp = this.carPosition.add(new Position(a, 0));
                        break;
                    case West:
                        temp = this.carPosition.add(new Position(-a, 0));

                        break;
                }
                if (temp.larger(topLeft) && temp.smaller(bottomRight))
                    this.carPosition = temp;
                break;
            case Right:
                this.carDir = this.carDir.next();
                break;
            case Left:
                this.carDir = this.carDir.prev();
                break;
            default:
        }
    }

    public static void main(String[] args) {
        Car newCar = new Car();
        System.out.println(newCar.toString());
        /*
        newCar.move(MoveDirection.Left);
        newCar.move(MoveDirection.Backward);
        newCar.move(MoveDirection.Backward);
        newCar.move(MoveDirection.Backward);
*/
        MoveDirection[] moves = OptionsParser.parse(args);
        for (MoveDirection tmp : moves)
            newCar.move(tmp);

        System.out.println(newCar.toString());
    }
}
