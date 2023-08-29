package com.example.helloworld;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DragAndDrop extends Application {

     public static void main(String[] args) {
        Application.launch(args);
    }
    double mouse_x,mouse_y;
     boolean isEntered = false;

    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello Drag and Drop");
        Group root = new Group();
        Scene scene = new Scene(root,500,200);
        scene.setFill(Color.WHITE);

        FigureGroup source = new FigureGroup(80,50,40, Color.LIGHTBLUE,"SOURCE");
        FigureGroup target = new FigureGroup(320, 50,50,Color.RED,"DROP TARGET");

        source.getFigure().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouse_x= mouseEvent.getScreenX();
                mouse_y= mouseEvent.getScreenY();

            }
        });

        source.getFigure().setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                source.getFigure().setMouseTransparent(true);
                source.getFigure().toFront();
                source.getFigure().startFullDrag();
            }
        });
        source.getFigure().setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //calculates the difference between the current X coordinate of
                // the mouse pointer (mouseEvent.getSceneX()) and the initial X coordinate (mouse_x).
                double deltaX= mouseEvent.getSceneX()-mouse_x;
                double deltaY= mouseEvent.getSceneY()-mouse_y;
                source.setPosition(deltaX,deltaY);
                mouse_x= mouseEvent.getScreenX();
                mouse_y= mouseEvent.getScreenY();
                source.getFigure().setLayoutX(deltaX);
                source.getFigure().setLayoutY(deltaY);





            }
        });
        source.getFigure().setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (!isEntered){
                    System.out.println("Mouse released is work!!");
                    source.setBackOrigin();
                    source.getFigure().setMouseTransparent(false);
                }
                else {
                    target.getFigure().getChildren().add(source.getFigure());
                }

            }
        });
        target.getFigure().setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent mouseDragEvent) {
                isEntered = true;
            }
        });
        target.getFigure().setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent mouseDragEvent) {
                isEntered = false;
            }
        });
        root.getChildren().addAll(source.getFigure(),target.getFigure());
        stage.setScene(scene);
    stage.show();
    }
}
