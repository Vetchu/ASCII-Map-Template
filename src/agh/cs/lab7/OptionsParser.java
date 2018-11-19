package agh.cs.lab7;

import java.util.Arrays;

class OptionsParser {
     MoveDirection[] parse(String[] args){
        MoveDirection returnArray[]=new MoveDirection[args.length];
        int j=0;
         for (String arg : args) {
             String lowerCase = arg.toLowerCase();
             switch (lowerCase) {
                 case "f":
                 case "forward":
                     returnArray[j++] = MoveDirection.Forward;
                     break;
                 case "b":
                 case "backwards":
                     returnArray[j++] = MoveDirection.Backward;
                     break;
                 case "r":
                 case "right":
                     returnArray[j++] = MoveDirection.Right;
                     break;
                 case "l":
                 case "left":
                     returnArray[j++] = MoveDirection.Left;
                     break;
                     default:
                         throw new IllegalArgumentException(arg+": argument is invalid");
             }
         }
        if(j!=0)  returnArray= Arrays.copyOfRange(returnArray,0,j-1);
        return returnArray;
    }
}