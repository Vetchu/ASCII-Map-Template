package agh.cs.lab5;

public class Car implements IMapElement{
    private MapDirection direction = MapDirection.North;
    private Position position = new Position(2, 2);
    private IWorldMap map;

    public String toString() {
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
    public Position getPosition(){
        return this.position;
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
    Car(){

    }
    Car(IWorldMap map){
        this.map=map;
    }
    Car(IWorldMap map, int x, int y){
        this.position =new Position(x,y);
        this.map=map;
    }
    public void wzium(String[] args) {
        MoveDirection[] moves = new OptionsParser().parse(args);
        for (MoveDirection move : moves) {
            move(move);
        }
    }
}
