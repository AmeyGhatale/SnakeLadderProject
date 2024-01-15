package com.example.snakeladderproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {

    public static final int tileSize = 50, width = 10, height = 10;

    boolean player1Switch = false, player2Switch = false, startSwitch = false;
    private Pane createContent()
    {
        Pane pane = new Pane();

        Dice dice = new Dice();
        Player player1, player2;

        //Set Size of Scene
        pane.setPrefSize(tileSize*height, tileSize*width+100);

        //Adding Tiles
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                pane.getChildren().add(tile);
            }
        }

        //Add Image
        Image image = new Image("D:\\Idea_Projects\\SnakeLadderProject\\src\\main\\sl.jpg");
        ImageView board = new ImageView();
        board.setImage(image);
        board.setFitHeight(tileSize*height);
        board.setFitWidth(tileSize*width);

        //Buttons
        Button player1Button = new Button("Player 1");
        Button player2Button = new Button("Player 2");
        Button start = new Button("Start");

        // X-Y Cord. of Buttons
        player1Button.setTranslateX(50);
        player1Button.setTranslateY(550);
        player1Button.setDisable(true);
        player2Button.setTranslateX(400);
        player2Button.setTranslateY(550);
        player2Button.setDisable(true);
        start.setTranslateX(230);
        start.setTranslateY(550);

        //Buttons Label
        Label player1Label = new Label("");
        Label player2Label = new Label("");
        Label startLabel = new Label("Start Game");

        // X-Y Cord. of Labels
        player1Label.setTranslateX(40);
        player1Label.setTranslateY(530);
        player2Label.setTranslateX(390);
        player2Label.setTranslateY(530);
        startLabel.setTranslateX(220);
        startLabel.setTranslateY(530);

        player1 = new Player(tileSize-5, Color.BLACK, "Amey");
        player2 = new Player(tileSize-13, Color.SANDYBROWN, "Nishant");


        //Player 1 Button
        player1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(player1Switch) {
                    player2Label.setText(player2.getName() + "'s Turn!");
                    double diceValue = dice.getRolledDiceVlaue();
                    player1.movePlayer((int) diceValue);
                    startLabel.setText("Dice Value : " + (int) diceValue);
                    player1Label.setText("");

                    if(player1.isWinner()){
                        player1Button.setDisable(true);
                        player2Button.setDisable(true);
                        player1Switch = false;
                        player2Switch = false;
                        startLabel.setText("Winner is  " + player1.getName()+"!!!!");
                        player1Label.setText("");
                        player2Label.setText("");

                        start.setText("Start Again");
                        start.setDisable(false);
                    }
                    else {
                        player1Button.setDisable(true);
                        player2Button.setDisable(false);
                        player1Switch = false;
                        player2Switch = true;
                    }
                }
            }
        });

        //Player 2 Button
        player2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(player2Switch) {
                    player1Label.setText(player1.getName() + "'s Turn!");
                    double diceValue = dice.getRolledDiceVlaue();
                    player2.movePlayer((int) diceValue);
                    startLabel.setText("Dice Value : " + (int) diceValue);
                    player2Label.setText("");

                    if(player2.isWinner()){
                        player1Button.setDisable(true);
                        player2Button.setDisable(true);
                        player1Switch = false;
                        player2Switch = false;
                        startLabel.setText("Winner is  " + player2.getName()+"!!!!");
                        player1Label.setText("");
                        player2Label.setText("");

                        start.setText("Start Again!");
                        start.setDisable(false);
                    }
                    else {
                        player1Button.setDisable(false);
                        player2Button.setDisable(true);
                        player1Switch = true;
                        player2Switch = false;
                    }
                }
            }
        });

        //Start Button
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                startLabel.setText("Game Started!");
                start.setDisable(true);

                player1.startingPosition();
                player2.startingPosition();
                player1.setCurrentPosition(1);
                player2.setCurrentPosition(1);
                player1Label.setText(player1.getName()+"'s Turn!");
                player2Button.setDisable(true);
                player1Switch = true;
                player1Button.setDisable(false);
            }
        });

        //Add all Changes to Scene
        pane.getChildren().addAll(
                board, player2Button, player1Button, start,
                player1Label, player2Label, startLabel,
                player1.getToken(), player2.getToken()
        );

        return pane;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeLadder.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake Ladder Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}