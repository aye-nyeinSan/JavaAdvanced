package com.example.helloworld;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Test extends Application {

    public static void main(String [] args ){
      launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();
        Button btn = new Button();
        btn.setText("Hello hus ");


        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.print("Hello");
            }
        });
        root.getChildren().add(btn);

    Scene scene=new Scene(root,300,275);
    scene.widthProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observableValue, Number oldNumber, Number newNumber) {
         System.out.println("Width :" + newNumber);        }
    });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldNumber, Number newNumber) {
                System.out.println("height :" + newNumber);        }
        });

        stage.setScene(scene);


        stage.show();

    }
}
