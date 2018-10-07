package agh.cs.lab3;

public class Position {
    private final int x,y;

    Position(int x,int y){
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
        System.out.println(second.x+" "+second.y);
        return new Position(second.x+this.x,second.y+this.y);
    }
    public boolean equals(Position other){
        return (this.x==other.x&&this.y==other.y);
    }

    public static void main(String[] args){
        Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
}
