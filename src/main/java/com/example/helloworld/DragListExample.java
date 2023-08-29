package com.example.helloworld;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DragListExample extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label sourcelistLb1 =new Label("Source List");
        Label targetlistLb1 =new Label("Target List");
        ObservableList<String> list = FXCollections.observableArrayList();//Declare arraylist for input
        list.addAll("Java","Python","Ruby","R","Go","C");
        DragListModel sourceView = new DragListModel();//
        DragListModel targetView = new DragListModel();//
        sourceView.lV.getItems().addAll(list);
        GridPane gridPane = new GridPane();
        gridPane.addRow(1, sourcelistLb1,targetlistLb1);
        gridPane.addRow(2, sourceView.lV , targetView.lV);
        VBox root=new VBox();
        root.getChildren().add(gridPane);
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Drag and Drop Items in List");
        stage.show();

    }


}
