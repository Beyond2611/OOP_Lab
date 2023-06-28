package hust.soict.globalict.javafx;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;


public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton pen;
    @FXML
    private RadioButton eraser;

    @FXML
    public void clearButtonPressed(ActionEvent event){
        drawingAreaPane.getChildren().clear();
    }
    @FXML
    public void drawingAreaMouseDragged(MouseEvent event){
        Circle newCircle = new Circle(event.getX(),event.getY(),4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    public void erasingAreaMouseDragged(MouseEvent event){
        Circle newCircle = new Circle(event.getX(), event.getY() , 12 , Color.WHITE);
        drawingAreaPane.getChildren().add(newCircle);
    }

    public void handleRadioButton(ActionEvent event){
        if(pen.isSelected()) drawingAreaPane.setOnMouseDragged(event1 -> drawingAreaMouseDragged(event1));
        if(eraser.isSelected()) drawingAreaPane.setOnMouseDragged(event1 -> erasingAreaMouseDragged(event1));
    }
}
