package bcs.csc325.tipcalculator_325;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Button calculateButton;
    @FXML
    private Label tipSliderVal;
    @FXML
    private Slider tipSlider;
    @FXML
    private TextField amountTF;
    @FXML
    private TextField tipTF;
    @FXML
    private TextField totalTF;
    @FXML
    private Label tipLabel;

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();
    
    private BigDecimal tipPercentage = new BigDecimal(0.15);
    
    public void initialize(){
        currency.setRoundingMode(RoundingMode.HALF_UP);
        
        tipSlider.valueProperty().addListener(
                new ChangeListener<Number>(){
                    @Override
                    public void changed(ObservableValue<? extends Number> ov,
                            Number oldvalue, Number newValue){
                        tipPercentage = 
                                BigDecimal.valueOf(newValue.intValue()/100.0);
                        tipSliderVal.setText(percent.format(tipPercentage));
                    }
                });
    }
    @FXML
    private void calculateButtonHandler(ActionEvent event) {
        try{
            BigDecimal amount = new BigDecimal(amountTF.getText());
            BigDecimal tip = amount.multiply(tipPercentage);
            BigDecimal total = amount.add(tip);
            
            tipTF.setText(currency.format(tip));
            totalTF.setText(currency.format(total));
    }
        catch(NumberFormatException ex){
            amountTF.setText("Enter Amount");
            amountTF.selectAll();
            amountTF.requestFocus();
        }
    }


    }

