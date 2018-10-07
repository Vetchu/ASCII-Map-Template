package agh.cs.lab1;

import java.util.stream.Stream;

public class CarSystem {
    private static void run() {
        System.out.println("Samochod jedzie do przodu.");


    }

    private static void run(String[] dir){
        /*
        for(int i=0;i<dir.length;i++){
            System.out.print(dir[i]);
            if(i!=dir.length-1)System.out.print(",");
        }
        System.out.println();
        */
        for(int i=0;i<dir.length;i++) {
            switch (dir[i]){
                case "f":
                    System.out.println("Samochod jedzie do przodu.");
                    break;
                case "l":
                    System.out.println("Samochod jedzie w lewo.");
                    break;
                case "r":
                    System.out.println("Samochod jedzie w prawo.");
                    break;
                case "b":
                    System.out.println("Samochod jedzie do tyłu.");
                    break;
                    default:

            }
        }
    }

    private static void run(Direction[] dir){
        for(int i=0;i<dir.length;i++) {
            switch (dir[i]){
                case forward:
                    System.out.println("Samochod jedzie do przodu.");
                    break;
                case left:
                    System.out.println("Samochod jedzie w lewo.");
                    break;
                case right:
                    System.out.println("Samochod jedzie w prawo.");
                    break;
                case back:
                    System.out.println("Samochod jedzie do tyłu.");
                    break;
                //default:
                //    System.out.println("Niepoprawna Komenda");

            }
        }
    }
    private static void run(Stream<Direction> dir){

    }
    private static Direction[] convert(String[] args){
        Direction test[]=new Direction[args.length];
        for(int i=0;i<args.length;i++){
            switch(args[i]){
                case "f":
                    test[i]=Direction.forward;
                    break;
                case "l":
                    test[i]=Direction.left;
                    break;
                case "r":
                    test[i]=Direction.right;
                    break;
                case "b":
                    test[i]=Direction.back;
                    break;
                default:

            }
        }
        return test;
    }
    public static void main(String[] args){
        System.out.println("Start Systemu");
        Direction enumerated[]=convert(args);

        Stream.of(args).forEach(arg->{switch(arg){
            case "f":
                System.out.println("Samochod jedzie do przodu.");
                break;
            case "l":
                System.out.println("Samochod jedzie w lewo.");
                break;
            case "r":
                System.out.println("Samochod jedzie w prawo.");
                break;
            case "b":
                System.out.println("Samochod jedzie do tyłu.");
                break;
            default:
        }});

        //run(enumerated);
        //run(args);
        System.out.println("Koniec Systemu");
    }
}
