package com.example.snakeladderproject;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle token;
    private int currentPosition;
    private String name;
    Board gameBoard = new Board();


    public Player(int tileSize, Color color, String name)
    {
        token = new Circle(tileSize/2);
        token.setFill(color);
        this.name = name;
        currentPosition = 1;
        startingPosition();
    }

    public void startingPosition()
    {
//        int x = gameBorad.getXCordinate(1);
//        int y = gameBorad.getYCordinate(1);

        token.setTranslateX(25);
        token.setTranslateY(475);
    }

    public void movePlayer(int diceValue)
    {
        if(currentPosition+diceValue <= 100 ) {
            currentPosition += diceValue;

            TranslateTransition firstMove =  translateAnimation(diceValue), secondMove = null;

             int newPosition = gameBoard.getPosition(currentPosition);
             if(newPosition!=-1 && newPosition!=currentPosition){
                 currentPosition = newPosition;
                 secondMove = translateAnimation(diceValue);
             }

             if(secondMove==null)
                 firstMove.play();
             else {
                 SequentialTransition sq = new SequentialTransition(firstMove, new PauseTransition(Duration.millis(300)),  secondMove);
                 sq.play();
             }
        }
//

    }

    public boolean isWinner()
    {
        if(currentPosition == 100)
            return true;
        return false;
    }

    public TranslateTransition translateAnimation(int diceValue)
    {
        TranslateTransition animate = new TranslateTransition(Duration.millis(150*diceValue), token);
        animate.setToX(gameBoard.getXCordinate(currentPosition));
        animate.setToY(gameBoard.getYCordinate(currentPosition));
        animate.setAutoReverse(false);
         return animate;
    }

    public Circle getToken() {
        return token;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
