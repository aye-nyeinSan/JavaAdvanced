package com.example.helloworld;

import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.*;

public class DragListModel {
    ListView<String> lV;
    public DragListModel(){
        lV = new ListView<String>();
        lV.setPrefSize(200,200);
        lV.setOnDragDetected(new EventHandler<MouseEvent>() { //
            @Override
            public void handle(MouseEvent mouseEvent) {
                Dragboard dragboard = lV.startDragAndDrop(TransferMode.MOVE);
                String selectedItems = lV.getSelectionModel().getSelectedItem();
                ClipboardContent content = new ClipboardContent();
                content.putString(selectedItems);
                dragboard.setContent(content);
            }
        });

        lV.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                Dragboard dragboard = dragEvent.getDragboard();
                if(dragEvent.getGestureSource() != lV && dragboard.hasString()){
                    //checks if the source of the drag event is not the ListView (lV) itself
                    // and if the dragged data on the Dragboard is of type String.
                dragEvent.acceptTransferModes(TransferMode.MOVE);}

            }
        });

        lV.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                boolean dragCompleted = false;
                Dragboard dragboard = dragEvent.getDragboard();
                if(dragboard.hasString()){
                    String list = dragboard.getString();
                    lV.getItems().addAll(list);
                    dragCompleted = true;
                }
                dragEvent.setDropCompleted(dragCompleted);
            }
        });

        lV.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                lV.getItems().remove(lV.getSelectionModel().getSelectedItem());
            }
        });
    }

}
