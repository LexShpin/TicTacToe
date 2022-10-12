package com.example.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TicTacToeApplication extends Application {

    private ArrayList<Button> playBtns;
    private String currentPlayer;

    public TicTacToeApplication() {
        this.playBtns = new ArrayList<>();
        this.currentPlayer = "X";
    }

    @Override
    public void start(Stage stage) {

        BorderPane layout = new BorderPane();
        GridPane gameGrid = new GridPane();

        Label turnInfo = new Label("Turn: " + currentPlayer);
        Button resetGame = new Button("Reset");
        Button b1 = new Button("");
        Button b2 = new Button("");
        Button b3 = new Button("");
        Button b4 = new Button("");
        Button b5 = new Button("");
        Button b6 = new Button("");
        Button b7 = new Button("");
        Button b8 = new Button("");
        Button b9 = new Button("");

        HBox top = new HBox();
        top.setSpacing(50);
        top.setAlignment(Pos.CENTER);

        turnInfo.setFont(Font.font("Monospaced bold", 40));

        top.getChildren().addAll(turnInfo, resetGame);

        styleButtons(b1, b2, b3, b4, b5, b6, b7, b8, b9);

        setGrid(gameGrid, b1, b2, b3, b4, b5, b6, b7, b8, b9);


        this.playBtns = addBtnsToArrayList(b1, b2, b3, b4, b5, b6, b7, b8, b9);

        for (Button btn: this.playBtns) {
            btn.setOnAction((event) -> {
                if (!btn.getText().isEmpty()) {
                    return;
                }

                btn.setText(this.currentPlayer);

                switchPlayer();
                turnInfo.setText("Turn: " + currentPlayer);
                defineWinner();
            });
        }

        resetGame.setOnAction((event) -> {
            for (Button btn: this.playBtns) {
                btn.setText("");
            }

            this.currentPlayer = "X";
            turnInfo.setText("Turn: " + this.currentPlayer);
        });

        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.setTop(top);
        layout.setCenter(gameGrid);

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    public void styleButtons(Button b1, Button b2, Button b3, Button b4, Button b5, Button b6, Button b7, Button b8, Button b9) {
        b1.setFont(Font.font("Monospaced", 40));
        b2.setFont(Font.font("Monospaced", 40));
        b3.setFont(Font.font("Monospaced", 40));
        b4.setFont(Font.font("Monospaced", 40));
        b5.setFont(Font.font("Monospaced", 40));
        b6.setFont(Font.font("Monospaced", 40));
        b7.setFont(Font.font("Monospaced", 40));
        b8.setFont(Font.font("Monospaced", 40));
        b9.setFont(Font.font("Monospaced", 40));

        b1.setPrefSize(90, 90);
        b2.setPrefSize(90, 90);
        b3.setPrefSize(90, 90);
        b4.setPrefSize(90, 90);
        b5.setPrefSize(90, 90);
        b6.setPrefSize(90, 90);
        b7.setPrefSize(90, 90);
        b8.setPrefSize(90, 90);
        b9.setPrefSize(90, 90);
    }

    public void setGrid(GridPane grid, Button b1, Button b2, Button b3, Button b4, Button b5, Button b6, Button b7, Button b8, Button b9) {
        grid.add(b1, 0, 0);
        grid.add(b2, 0, 1);
        grid.add(b3, 0, 2);
        grid.add(b4, 1, 0);
        grid.add(b5, 1, 1);
        grid.add(b6, 1, 2);
        grid.add(b7, 2, 0);
        grid.add(b8, 2, 1);
        grid.add(b9, 2, 2);

        grid.setHgap(5);
        grid.setVgap(5);
    }

    public ArrayList<Button> addBtnsToArrayList(Button b1, Button b2, Button b3, Button b4, Button b5, Button b6, Button b7, Button b8, Button b9) {
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);
        buttons.add(b9);

        return buttons;
    }

    public void switchPlayer() {
        if (this.currentPlayer.equals("X")) {
            this.currentPlayer = "O";
        } else {
            this.currentPlayer = "X";
        }
    }

    public void defineWinner() {

    }
}
