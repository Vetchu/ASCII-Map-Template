package agh.cs.lab6;

public class HayStack implements IMapElement {
    Position position;
    public Position getPosition(){
        return this.position;
    }
    public String toString(){
        return "S";
    }
    HayStack(Position position){
        this.position=position;
    }
}
