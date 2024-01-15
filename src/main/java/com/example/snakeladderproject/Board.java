package com.example.snakeladderproject;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    public static ArrayList<Pair<Integer, Integer>> cordinates;
    public ArrayList<Integer> position;
    
    public Board()
    {
        cordinates = new ArrayList<>();
        position  = new ArrayList<>();
        setCordinates(cordinates);
        populatePosition();
    }

    public void populatePosition()
    {
        for (int i = 0; i < 101; i++) {
            position.add(i);
        }

        position.set(4, 14);
        position.set(9, 31);
        position.set(21, 42);
        position.set(28, 84);
        position.set(51, 67);
        position.set(72, 91);
        position.set(80, 99);
        position.set(17, 7);
        position.set(54, 34);
        position.set(64, 60);
        position.set(62, 19);
        position.set(87, 36);
        position.set(93, 73);
        position.set(95, 75);
        position.set(98, 79);
    }

    public int getPosition(int currentVal)
    {
        if(currentVal <= 100)
            return position.get(currentVal);
        return -1;
    }
    
    public void setCordinates(ArrayList<Pair<Integer, Integer>> cordinates)
    {
        cordinates.add(new Pair<>(250, 500));
        for (int i = 0; i <SnakeLadder.height; i++) {
            for (int j = 0; j < SnakeLadder.width; j++) {
                //X-Cordinate
                int xCord;
                if(i%2!=0)
                    xCord = SnakeLadder.tileSize*SnakeLadder.height - (SnakeLadder.tileSize * j )-25;
                else
                    xCord = SnakeLadder.tileSize * j + 25;

                //Y-Cordinates
                int yCord = SnakeLadder.tileSize*SnakeLadder.height - (SnakeLadder.tileSize * i )-25;

                cordinates.add(new Pair<>(xCord, yCord));
            }
        }
    }

    public int getXCordinate(int position)
    {
        if(position<=100)
            return cordinates.get(position).getKey();
        return -1;
    }
    public int getYCordinate(int position)
    {
        if(position<=100)
            return cordinates.get(position).getValue();
        return -1;
    }

    public static void main(String[] args) {
        Board b = new Board();

        for (int i = 0; i < b.cordinates.size(); i++) {
                System.out.println(
                        i+"  x:"+cordinates.get(i).getKey()+"  y:"+cordinates.get(i).getValue()
                );
        }
    }
}
