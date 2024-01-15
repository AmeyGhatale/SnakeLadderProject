package com.example.snakeladderproject;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    public Tile(int tileSize){
        setWidth(tileSize);
        setHeight(tileSize);
        setFill(Color.WHITE);
        setStroke(Color.BLACK);
    }
}
