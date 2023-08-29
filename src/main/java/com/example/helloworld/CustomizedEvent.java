package com.example.helloworld;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.io.IOException;

public class CustomizedEvent extends Application{
    double originX,originY;
    double newX,newY;
    @Override
    public void start(Stage stage) {

        StackPane circle1= createMonitoredCircle();
      //  StackPane circle2= createMonitoredCircle();

        FlowPane pane=new FlowPane();
        pane.getChildren().addAll(circle1);
        Scene scene=new Scene(pane);
        stage.setTitle("Customized Events");
        stage.setScene(scene);
        stage.show();

    }
    private StackPane createMonitoredCircle(){

        StackPane pane= new StackPane();//container /root
        Group gp =new Group();
       // VBox layout =new VBox();
        Group layout= new Group();//start from right
        Label reporter=new Label("Outside circle");
        reporter.setPadding(new Insets(20));
        Circle circle=new Circle(80);
        //Circle circle2=new Circle(80);
        circle.setFill(Color.PINK);
       //layout.setPadding(new Insets(20));

        //Mouse events
        circle.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                reporter.setText("(x: "+event.getX()+ ", y: "+event.getY()+")");
            }
        });
//        circle.setOnMouseClicked(mouseEvent -> { //events MousePressed+MouseReleased
//            System.out.println("MouseClicked is work!");
//            reporter.setText("Circle is clicked!!");
//
//        });
//        circle2.setOnMouseClicked(mouseEvent -> { //events MousePressed+MouseReleased
//            System.out.println("MouseClicked is work!");
//            reporter.setText("Circle is clicked!!");
//            circle2.setRadius(0);
//
//        });
        //Once I pressed the mouse, MousePressed ,MouseReleased and MouseEntered is worked!!!!
        circle.setOnMousePressed(mouseEvent ->  {
            originX = mouseEvent.getScreenX();
            originY = mouseEvent.getScreenY();
            System.out.println("MousePressed is work!\t"+ originX+" "+originY);
        });


//        circle.setOnMouseEntered(mouseEvent -> {System.out.println("MouseEntered :true");});

        circle.setOnDragDetected(mouseEvent -> {
            System.out.println("DragDetected is work!");
            circle.setMouseTransparent(true);
            circle.toFront();
            circle.startFullDrag();
        });

        //Working as Dragging Mouse inside the scene
        circle.setOnMouseDragged(mouseEvent -> {
            System.out.println("MouseDragged is work!");
             newX= mouseEvent.getScreenX() ;
            newY= mouseEvent.getScreenY();
            circle.setLayoutX(newX);
            circle.setLayoutY( newY);


           // reporter.setText("(NewX: "+newX+ ", NewY: "+newy+")");

        });
        circle.setOnMouseReleased(mouseEvent -> {
            System.out.println("MouseReleased is work!");
            circle.setLayoutX(newX);
            circle.setLayoutY(newY);
            circle.setMouseTransparent(false);
        });

        circle.setOnMouseDragEntered(mouseDragEvent ->{
            System.out.println("MouseDraggedEntered is work!");});

        circle.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                reporter.setText("Outside Circle");
            }
        });

        layout.getChildren().setAll(circle,reporter);
        gp.getChildren().add(layout);
        pane.getChildren().add(gp);
        return pane;
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
