package agh.cs.lab5;

public class Car implements IMapElement{
    private MapDirection carDir = MapDirection.North;
    private Position position = new Position(2, 2);
    private IWorldMap map;
    public String toString() {
        return carDir.toString().substring(0,1);
    }
    public Position getPosition(){
        return this.position;
    }

    void move(MoveDirection direction) {
        switch (direction) {
            case Forward:
            case Backward:
                int a = (direction == MoveDirection.Forward) ? 1 : -1;
                Position topLeft = new Position(1, 1);
                Position bottomRight = new Position(3, 3);
                Position temp=this.position;
                switch (this.carDir) {
                    case North:
                        temp = this.position.add(new Position(0, a));
                        break;
                    case South:
                        temp = this.position.add(new Position(0, -a));
                        break;
                    case East:
                        temp = this.position.add(new Position(a, 0));
                        break;
                    case West:
                        temp = this.position.add(new Position(-a, 0));
                        break;
                }
                if (temp.larger(topLeft) && temp.smaller(bottomRight))
                    if(map.canMoveTo(temp))
                    this.position = temp;
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
        this.position =new Position(x,y);
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
