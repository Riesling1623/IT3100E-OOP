package hust.soict.dsai.javafx;

import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup identical;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        RadioButton selecteRadioButton = (RadioButton) identical.getSelectedToggle();
        if (selecteRadioButton != null){
            if (selecteRadioButton.getText().equals("Eraser")){
                Circle eraserCircle = new Circle(event.getX(), event.getY(), 10, Color.WHITE);
                drawingAreaPane.getChildren().add(eraserCircle);
            } else {
                Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
                drawingAreaPane.getChildren().add(newCircle);
            }
        }
    }
}
