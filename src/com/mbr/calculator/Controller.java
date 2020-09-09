package com.mbr.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField display;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button0;
    @FXML
    private Button buttonClear;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonMinus;
    @FXML
    private Button buttonMultiply;
    @FXML
    private Button buttonDivide;
    @FXML
    private Button buttonDot;

    String equation;
    boolean buttonAddPressed = false;
    boolean buttonMinusPressed = false;
    boolean buttonDividePressed = false;
    boolean buttonMultiplyPressed = false;


    @FXML
    public void buttonPressed(ActionEvent event) {
        Button button = (Button) event.getSource();

        if (button == buttonClear) {
            clearDisplay();
        } else if (button == button0) {
            display.appendText("0");
        } else if (button == button1){
            display.appendText("1");
        } else if (button == button2){
            display.appendText("2");
        }else if (button == button3){
            display.appendText("3");
        }else if (button == button4){
            display.appendText("4");
        }else if (button == button5){
            display.appendText("5");
        }else if (button == button6){
            display.appendText("6");
        }else if (button == button7){
            display.appendText("7");
        }else if (button == button8){
            display.appendText("8");
        }else if (button == button9){
            display.appendText("9");
        }else if (button == buttonDot){
            display.appendText(".");
        }else if (button == buttonAdd){
            display.appendText("+");
            buttonAddPressed = true;
        }else if (button == buttonMinus){
            display.appendText("-");
            buttonMinusPressed = true;
        }else if (button == buttonMultiply){
            display.appendText("*");
            buttonMultiplyPressed =true;
        }else if (button == buttonDivide) {
            display.appendText("/");
            buttonDividePressed = true;
        }
    }

    @FXML
    public void buttonEqualsPressed(){

        equation = display.getText();
        String[] equationArray = equation.split("");
        double result = 0;
        StringBuilder number = new StringBuilder();

        for (String s : equationArray) {

            if (isNumeric(s) || s.equals(".")) {
                number.append(s);
            } else {
                result = Double.parseDouble(number.toString());
                number = new StringBuilder();
            }
        }

        if (buttonAddPressed){
            result = result + Double.parseDouble(number.toString());
        } else if (buttonMinusPressed){
            result = result - Double.parseDouble(number.toString());
        } else if (buttonMultiplyPressed){
            result = result * Double.parseDouble(number.toString());
        } else if (buttonDividePressed){
            result = result / Double.parseDouble(number.toString());
        }

        display.setText(Double.toString(result));

    }

    public static boolean isNumeric(String string){
        try{
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    @FXML
    public void clearDisplay(){
        display.setText("");

        buttonAddPressed = false;
        buttonMinusPressed = false;
        buttonDividePressed = false;
        buttonMultiplyPressed = false;
    }



}
