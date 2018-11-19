package agh.cs.lab7;

public class Position  {
    final int x;
    final int y;

    public Position(int x, int y) {
        this.x=x;
        this.y=y;

    }

    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }
    public boolean smaller(Position second){
        return (this.x-second.x<=0&&this.y-second.y<=0);
    }
    public boolean larger(Position second){
        return (this.x-second.x>=0&&this.y-second.y>=0);
    }
    public Position add(Position second){
        return new Position(second.x+this.x,second.y+this.y);
    }

    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Position)) return false;
        return (this.hashCode()==other.hashCode());
    }

    public Position upperRight(Position second) {
        int newX = (second.x >= this.x) ? second.x : this.x;
        int newY = (second.y >= this.y) ? second.y : this.y;
        return new Position(newX, newY);
    }

    public Position lowerLeft(Position second) {
        int newX = (second.x >= this.x) ? this.x : second.x;
        int newY = (second.y >= this.y) ? this.y : second.y;
        return new Position(newX, newY);
    }

    public Position mult(int val){
        return new Position(this.x*val,this.y*val);
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }

    public static void main(String[] args){
        Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }


}
