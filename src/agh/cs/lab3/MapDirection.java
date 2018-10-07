package agh.cs.lab3;


enum MapDirection {
    North, South, West, East;

    public String toString() {
        switch (this){
            case North:
                return "Północ";
            case South:
                return "Południe";
            case West:
                return "Zachód";
            case East:
                return "Wschód";
        }
        return null;
    }

    public MapDirection next(){
        switch (this){
            case North:
                return East;
            case South:
                return West;
            case West:
                return North;
            case East:
                return South;
        }
        return null;
    }
    public MapDirection prev(){
        switch (this){
            case North:
                return West;
            case South:
                return East;
            case West:
                return South;
            case East:
                return North;
        }
        return null;
    }
}
