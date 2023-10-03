package bcs.csc325.colorchooser;

import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PrimaryController {

    @FXML
    private Slider redSlider;
    @FXML
    private Slider greenSlider;
    @FXML
    private Slider blueSlider;
    @FXML
    private Slider alphaSlider;
    @FXML
    private TextField redTF;
    @FXML
    private TextField greenTF;
    @FXML
    private TextField blueTF;
    @FXML
    private TextField alphaTF;
    @FXML
    private Rectangle colorRectangle;
    
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private double alpha = 1.0;
    
    public void initialize(){
        redTF.textProperty().bind(
        redSlider.valueProperty().asString("%.0f"));
        greenTF.textProperty().bind(
        greenSlider.valueProperty().asString("%.0f"));
        blueTF.textProperty().bind(
        blueSlider.valueProperty().asString("%.0f"));
        alphaTF.textProperty().bind(
        alphaSlider.valueProperty().asString("%.2f"));
        
        redSlider.valueProperty().addListener(
        new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                    Number oldValue, Number newValue){
                red = newValue.intValue();
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });
        greenSlider.valueProperty().addListener(
        new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                    Number oldValue, Number newValue){
                green = newValue.intValue();
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });
        blueSlider.valueProperty().addListener(
        new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                    Number oldValue, Number newValue){
                blue = newValue.intValue();
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });
        alphaSlider.valueProperty().addListener(
        new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                    Number oldValue, Number newValue){
                alpha = newValue.intValue();
                colorRectangle.setFill(Color.rgb(red, green, blue, alpha));
            }
        });
    }

}