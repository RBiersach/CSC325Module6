package bcs.csc325.colorchooser_325;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PrimaryController {


    private enum PenSize{
        SMALL(2),
        MEDIUM(4),
        LARGE(6);
        
        private final int radius;
        
        PenSize(int radius) {this.radius = radius;}
        
        public int getRadius(){return radius;}
   };

    @FXML
    private RadioButton blackRadioButton;
    @FXML
    private ToggleGroup colorToggleGroup;
    @FXML
    private RadioButton redRadioButton;
    @FXML
    private RadioButton greenRadioButton;
    @FXML
    private RadioButton blueRadioButton;
    @FXML
    private RadioButton smallRadioButton;
    @FXML
    private ToggleGroup sizeToggleGroup;
    @FXML
    private RadioButton mediumRadioButton;
    @FXML
    private RadioButton largeRadioButton;
    @FXML
    private Button undoButton;
    @FXML
    private Button clearButton;
    @FXML
    private Pane drawingAreaPane;
    
    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
    
    public void initialize(){
        blackRadioButton.setUserData(Color.BLACK);
        redRadioButton.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        blueRadioButton.setUserData(Color.BLUE);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);
    }

    @FXML
    private void undoButtonHandler(ActionEvent event) {
        int count = drawingAreaPane.getChildren().size();
        
        if (count > 0){
            drawingAreaPane.getChildren().remove(count-1);
        }
    }

    @FXML
    private void clearButtonHandler(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    @FXML
    private void drawingAreaMouseDragged(MouseEvent e) {
        Circle newCircle = new Circle(e.getX(), e.getY(),
        radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
    @FXML
    private void colorRadioButtonSelecte(ActionEvent e){
        brushColor = (Color) colorToggleGroup.getSelectedToggle().getUserData();
    }
    private void sizeRadioButtonSelecte(ActionEvent e){
        radius = (PenSize) sizeToggleGroup.getSelectedToggle().getUserData();
    }
    }

