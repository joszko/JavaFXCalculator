package com.mbr.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import org.mariuszgromada.math.mxparser.Expression;

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
    @FXML
    private GridPane gridPane;

    String equation;
    boolean buttonAddPressed = false;
    boolean buttonMinusPressed = false;
    boolean buttonDividePressed = false;
    boolean buttonMultiplyPressed = false;


    @FXML
    public void buttonPressed(ActionEvent event) {
        Button button = (Button) event.getSource();

        if (button.equals(buttonClear)) {
            clearDisplay();
        } else if (button.equals(button0)) {
            display.appendText("0");
        } else if (button.equals(button1)){
            display.appendText("1");
        } else if (button.equals(button2)){
            display.appendText("2");
        }else if (button.equals(button3)){
            display.appendText("3");
        }else if (button.equals(button4)){
            display.appendText("4");
        }else if (button.equals(button5)){
            display.appendText("5");
        }else if (button.equals(button6)){
            display.appendText("6");
        }else if (button.equals(button7)){
            display.appendText("7");
        }else if (button.equals(button8)){
            display.appendText("8");
        }else if (button.equals(button9)){
            display.appendText("9");
        }else if (button.equals(buttonDot)){
            display.appendText(".");
        }else if (button.equals(buttonAdd)){
            display.appendText("+");
            buttonAddPressed = true;
        }else if (button.equals(buttonMinus)){
            display.appendText("-");
            buttonMinusPressed = true;
        }else if (button.equals(buttonMultiply)){
            display.appendText("*");
            buttonMultiplyPressed =true;
        }else if (button.equals(buttonDivide)) {
            display.appendText("/");
            buttonDividePressed = true;
        }
    }

    @FXML
    public void buttonEqualsPressed(){

        equation = display.getText();

        // calculating result using mXparser

        Expression e = new Expression(equation);
        double result = e.calculate();
        display.setText(Double.toString(result));

        // calculating using my own "parser"

//        String[] equationArray = equation.split("");
//        double result = 0;
//        StringBuilder number = new StringBuilder();
//
//        for (String s : equationArray) {
//
//            if (isNumeric(s) || s.equals(".")) {
//                number.append(s);
//            } else {
//                result = Double.parseDouble(number.toString());
//                number = new StringBuilder();
//            }
//        }
//
//        if (buttonAddPressed){
//            result = result + Double.parseDouble(number.toString());
//        } else if (buttonMinusPressed){
//            result = result - Double.parseDouble(number.toString());
//        } else if (buttonMultiplyPressed){
//            result = result * Double.parseDouble(number.toString());
//        } else if (buttonDividePressed){
//            result = result / Double.parseDouble(number.toString());
//        }
//
//        display.setText(Double.toString(result));

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
    @FXML
    public void handleKeyPressed(KeyEvent keyEvent){
        System.out.println(keyEvent.getCode());
        if (keyEvent.getCode().equals(KeyCode.DELETE)) {
            clearDisplay();
        } else if (keyEvent.getCode().equals(KeyCode.DIGIT0) || keyEvent.getCode().equals(KeyCode.NUMPAD0)){
            display.appendText("0");
        }

    }



}
