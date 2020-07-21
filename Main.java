package com.JavaGame.Connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Connect4.fxml"));
        GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayGround();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    private MenuBar createMenu() {
        Menu fileMenu =  new Menu("File");

        MenuItem newGame = new MenuItem("New Game");
        newGame.setOnAction(event -> controller.resetGame());
        
        MenuItem resetGame = new MenuItem("Reset Game");
        resetGame.setOnAction(event -> controller.resetGame());
        
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        
        MenuItem exitGame = new MenuItem("Exit Game");
        exitGame.setOnAction(event -> exitGame());
        
        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutGame = new MenuItem("About Connect4");
        SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About the Developer");
        helpMenu.getItems().addAll(aboutGame, separator, aboutMe);

        aboutGame.setOnAction(event -> aboutConnect4());
        aboutMe.setOnAction(event -> aboutDeveloper());




        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return(menuBar);

    }


    private void aboutDeveloper() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Developer");
        alert.setHeaderText("Sai Prathyusha Nimmagadda");
        alert.setContentText("I am a new JAVA Developer aspiring to become a tech pro and to build many android games and applications in the future."+"Connect four is my first Application"+"Hope you enjoyed playing it ;)...");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the " +
                "players first choose a color and then take turns dropping colored discs " +
                "from the top into a seven-column, six-row vertically suspended grid. "+
                "The pieces fall straight down, occupying the next available space within the column. "+
                "The objective of the game is to be the first to form a horizontal, vertical, " +
                "or diagonal line of four of one's own discs. Connect Four is a solved game. " +
                "The first player can always win by playing the right moves.");

        alert.show();


    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
