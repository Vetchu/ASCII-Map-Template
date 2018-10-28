package agh.cs.lab3;

import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parse(String[] args){
        MoveDirection returnArray[]=new MoveDirection[args.length];
        int j=0;
        for(int i=0;i<args.length;i++) {
            String lowerCase=args[i].toLowerCase();
            switch (lowerCase) {
                case "f":
                case "forward":
                    returnArray[j++]= MoveDirection.Forward;
                    break;
                case "b":
                case "backwards":
                    returnArray[j++]= MoveDirection.Backward;
                    break;
                case "r":
                case "right":
                    returnArray[j++]= MoveDirection.Right;
                    break;
                case "l":
                case "left":
                    returnArray[j++]= MoveDirection.Left;
                    break;
            }
        }
        return Arrays.copyOf(returnArray,j);
    }
}
