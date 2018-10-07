package agh.cs.lab4;

public class Car {
    private MapDirection carDir = MapDirection.North;
    private Position carPosition = new Position(2, 2);
    private IWorldMap map;
    public String toString() {
        return carDir.toString().substring(0,1);
    }
    Position getCarPosition(){
        return carPosition;
    }

    void move(MoveDirection direction) {
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
                    if(!map.isOccupied(temp))
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

    Car(){

    }
    Car(IWorldMap map){
        this.map=map;
    }
    Car(IWorldMap map, int x, int y){
        this.carPosition=new Position(x,y);
        this.map=map;
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
        MoveDirection[] moves = new OptionsParser().parse(args);
        for (MoveDirection tmp : moves)
            newCar.move(tmp);

        System.out.println(newCar.toString());
    }
}
