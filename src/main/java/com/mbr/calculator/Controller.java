package com.mbr.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.mariuszgromada.math.mxparser.Expression;

import java.util.Arrays;

import static java.lang.Math.sqrt;

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
    private Button buttonPercent;
    @FXML
    private Button buttonCE;
    @FXML
    private Button buttonBackspace;
    @FXML
    private Button button1DivByX;
    @FXML
    private Button buttonPower;
    @FXML
    private Button buttonSquareRoot;
    @FXML
    private Button buttonNegative;

    String equation;

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
        }else if (button.equals(buttonMinus)){
            display.appendText("-");
        }else if (button.equals(buttonMultiply)){
            display.appendText("*");
        }else if (button.equals(buttonDivide)) {
            display.appendText("/");
        } else if (button.equals(buttonPercent)){
            display.appendText("%");
        } else if (button.equals(button1DivByX)){
            display.setText(String.valueOf(1/calculate(display.getText())));
        } else if (button.equals(buttonBackspace)){
            display.setText(removeLastCharacter(display.getText()));
        } else if (button.equals(buttonCE)){
            display.setText(removeLastCharacter(display.getText()));
        } else if (button.equals(buttonSquareRoot)){
            display.setText(String.valueOf(sqrt(calculate(display.getText()))));
        } else if (button.equals(buttonPower)) {
            display.setText(String.valueOf(calculate(display.getText()) * calculate(display.getText())));
        } else if (button.equals(buttonNegative)){
            display.setText(String.valueOf(calculate(display.getText()) * -1));
        }
    }

    public double calculate(String equation){
        Expression e = new Expression(equation);
        return e.calculate();
    }

    @FXML
    public void buttonEqualsPressed(){

        equation = display.getText();

        // calculating result using mXparser

        Expression e = new Expression(equation);
        double result = e.calculate();
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
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent){

        String[] mathCharacters = {"ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "DECIMAL"};

        System.out.println(keyEvent.getCode());
        if (keyEvent.getCode().equals(KeyCode.DELETE)) {
            clearDisplay();
        } else if (isNumeric(keyEvent.getText())){
            display.appendText(keyEvent.getText());
        } else if (Arrays.asList(mathCharacters).contains(String.valueOf(keyEvent.getCode()))){
            display.appendText(keyEvent.getText());
        } else if (keyEvent.getCode().equals(KeyCode.ENTER)){
            buttonEqualsPressed();
        } else if (keyEvent.getCode().equals(KeyCode.BACK_SPACE)){
            display.setText(removeLastCharacter(display.getText()));
        }
    }

    public String removeLastCharacter(String str){
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
