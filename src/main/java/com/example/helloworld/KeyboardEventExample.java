package com.example.helloworld;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KeyboardEventExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Keyboard Event Example");
        Group root = new Group();
        Scene scene = new Scene(root,500, 200);
        scene.setFill(Color.WHITE);
        FigureGroup obj = new FigureGroup(200,50,50,Color.CORAL,"FIGURE");//create circle
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.UP){
                    obj.setPosition(0,-5);
                } else if (keyEvent.getCode() == KeyCode.DOWN) {
                    obj.setPosition(0,5);
                } else if (keyEvent.getCode() == KeyCode.LEFT) {
                    obj.setPosition(-5,0);
                } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                    obj.setPosition(5,0);
                }
            }
        });
        root.getChildren().add(obj.getFigure());
        stage.setScene(scene);
        stage.show();
    }
}
