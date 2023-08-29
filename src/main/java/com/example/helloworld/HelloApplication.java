package com.example.helloworld;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // UI with fxmlfile

        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/

        Button btn= new Button();
        btn.setText("Say Hello");

        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Hello from parallel world!!");
            }
        });

        StackPane root= new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root,300,275);
        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue,
                                Number oldSceneWidth, Number newSceneWidth) {
                System.out.println("Width: "+newSceneWidth);
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue,
                                 Number oldSceneHeight, Number newSceneHeight) {
                System.out.println("Height :"+newSceneHeight);

            }
        });
        stage.setTitle("Testing");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();

    }
}