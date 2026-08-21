package Stardance_Calculator;

import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.animation.Animation;
import javafx.util.Duration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;


import static javafx.scene.paint.Color.BLUE;


public class Main extends Application{

    // 25 pixel incremental for x direction

    int y_pos = 0;
    int x_pos = 130;
    int counter = 0;
    // manual double checkers
    int Plus_consecutive = 1;
    int Minus_consecutive = 0;
    int Div_consecutive = 0;
    int Mult_consecutive = 0;
    int L_Consecutive = 0;
    int R_Consecutive = 1;
    int implicit_mult = 0;

    @Override
    public void start(Stage stage){
        stage.setScene(Calculator_UI(stage));
    }
    public Scene Calculator_UI(Stage stage){
        ScaleTransition shrink_press = new ScaleTransition(Duration.millis(1000));
        shrink_press.setToX(0.9);
        shrink_press.setToY(0.9);
        shrink_press.setAutoReverse(true);
        shrink_press.setCycleCount(2);
        Pane root = new Pane();
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        Button four = new Button("4");
        Button five = new Button("5");
        Button six = new Button("6");
        Button seven = new Button("7");
        Button eight = new Button("8");
        Button nine = new Button("9");
        Button zero = new Button("0");

        TextField User_equation= new TextField();

        User_equation.setEditable(false);
       User_equation.setLayoutX(130);
       User_equation.setLayoutY(0);
        root.getChildren().add(User_equation);

        Button equals = new Button("=");
        root.getChildren().add(equals);
        equals.setLayoutX(x_pos +50);
        equals.setLayoutY(y_pos +125);
        equals.setOnAction(e->{

            String in_equation = User_equation.getText();
            System.out.println(in_equation);
            String result = Eval_Math.Equation(in_equation);
            User_equation.setText(result);
        });

        one.setLayoutX(x_pos +10);
        one.setLayoutY(y_pos +100);
        one.setTextFill(BLUE);
        root.getChildren().add(one);
        one.setOnAction(e->{
            if (User_equation.getText().contains("undefined")){
                User_equation.clear();
            }
            User_equation.appendText("1");
            Minus_consecutive = 0;
            Div_consecutive = 0;
            Mult_consecutive = 0;
            implicit_mult = 1;
        });


        two.setLayoutX(x_pos +30);
        two.setLayoutY(y_pos +100);
        root.getChildren().add(two);
        two.setOnAction(e->{
            if (User_equation.getText().contains("undefined")){
                User_equation.clear();
            }
            User_equation.appendText("2");
            Minus_consecutive = 0;
            Div_consecutive = 0;
            Mult_consecutive = 0;
            Plus_consecutive = 0;
        });



        three.setLayoutX(x_pos +50);
        three.setLayoutY(y_pos +100);
       root.getChildren().add(three);
        three.setOnAction(e->{
            if (User_equation.getText().contains("undefined")){
                User_equation.clear();
            }
            User_equation.appendText("3");
            Minus_consecutive = 0;
            Div_consecutive = 0;
            Mult_consecutive = 0;
            Plus_consecutive = 0;
        });


        four.setLayoutX(x_pos+10);
        four.setLayoutY(y_pos +75);
        root.getChildren().add(four);
        four.setOnAction(e->{
            if (User_equation.getText().contains("undefined")){
                User_equation.clear();
            }
            User_equation.appendText("4");
            Minus_consecutive = 0;
            Div_consecutive = 0;
            Mult_consecutive = 0;
            Plus_consecutive = 0;
        });



        five.setLayoutX(x_pos +30);
        five.setLayoutY(y_pos +75);
        root.getChildren().add(five);
        five.setOnAction(e->{
            if (User_equation.getText().contains("undefined")){
                User_equation.clear();
            }
            User_equation.appendText("5");
            Minus_consecutive = 0;
            Div_consecutive = 0;
            Mult_consecutive = 0;
            Plus_consecutive = 0;
        });



        six.setLayoutX(x_pos +50);
        six.setLayoutY(y_pos +75);
        root.getChildren().add(six);
        six.setOnAction(e->{
            if (User_equation.getText().contains("undefined")){
                User_equation.clear();
            }
            User_equation.appendText("6");
            Minus_consecutive = 0;
            Div_consecutive = 0;
            Mult_consecutive = 0;
            Plus_consecutive = 0;
        });


        seven.setLayoutX(x_pos +10);
        seven.setLayoutY(y_pos +50);
        root.getChildren().add(seven);
        seven.setOnAction(e->{
            if (User_equation.getText().contains("undefined")){
                User_equation.clear();
            }
            User_equation.appendText("7");
            Minus_consecutive = 0;
            Div_consecutive = 0;
            Mult_consecutive = 0;
            Plus_consecutive = 0;
        });


        eight.setLayoutX(x_pos +30);
        eight.setLayoutY(y_pos +50);
        root.getChildren().add(eight);
        eight.setOnAction(e->{
            if (User_equation.getText().contains("undefined")){
                User_equation.clear();
            }
            User_equation.appendText("8");
            Minus_consecutive = 0;
            Div_consecutive = 0;
            Mult_consecutive = 0;
            Plus_consecutive = 0;
        });


        nine.setLayoutX(x_pos +50);
        nine.setLayoutY(y_pos +50);
        root.getChildren().add(nine);
        nine.setOnAction(e->{
            if (User_equation.getText().contains("undefined")){
                User_equation.clear();
            }
            User_equation.appendText("9");
            Minus_consecutive = 0;
            Div_consecutive = 0;
            Mult_consecutive = 0;
            Plus_consecutive = 0;
        });


        zero.setLayoutX(x_pos +10);
        zero.setLayoutY(y_pos +125);
        root.getChildren().add(zero);
        zero.setOnAction(e->{
            if (User_equation.getText().contains("undefined")){
                User_equation.clear();
            }
            User_equation.appendText("0");
            Minus_consecutive = 0;
            Div_consecutive = 0;
            Mult_consecutive = 0;
            Plus_consecutive = 0;
        });

        //operations code
        Button plus = new Button("+");
        root.getChildren().add(plus);
        plus.setLayoutX(x_pos +70);
        plus.setLayoutY(y_pos +125);

        plus.setOnAction(e->{

            Plus_consecutive++;

            if(Plus_consecutive == 1) {
                User_equation.appendText("+");
                Minus_consecutive = 0;
                Div_consecutive = 0;
                Mult_consecutive = 0;
            }

        });


        Button minus = new Button("-");
        root.getChildren().add(minus);
        minus.setLayoutX(x_pos +70);
        minus.setLayoutY(y_pos +100);
        minus.setOnAction(e->{

            Minus_consecutive++;

            if(Minus_consecutive == 1) {

                User_equation.appendText("-");
                Plus_consecutive = 0;
            }
        });

        Button multi = new Button("*");
        root.getChildren().add(multi);
        multi.setLayoutX(x_pos +70);
        multi.setLayoutY(y_pos +75);
        multi.setOnAction(e->{
            Mult_consecutive++;

            if(Mult_consecutive == 1) {
                User_equation.appendText("*");

            }
        });

        Button divide = new Button("/");
        root.getChildren().add(divide);
        divide.setLayoutX(x_pos +70);
        divide.setLayoutY(y_pos +50);
        divide.setOnAction(e->{
            Div_consecutive++;
            if(Div_consecutive == 1) {
                User_equation.appendText("/");
                Minus_consecutive = 0;
            }

        });

        Button decimal = new Button(".");
        root.getChildren().add(decimal);
        decimal.setLayoutX(x_pos +30);
        decimal.setLayoutY(y_pos +125);
        decimal.setOnAction(e->{
            User_equation.appendText(".");
            counter++;
        });


        Button L_Parenthese = new Button("(");
        root.getChildren().add(L_Parenthese);
        L_Parenthese.setLayoutX(x_pos +10);
        L_Parenthese.setLayoutY(y_pos +25);
        L_Parenthese.setOnAction(e->{
            System.out.print(User_equation.getText());

            L_Consecutive++;
            if(L_Consecutive == 1) {
                User_equation.appendText("(");
                R_Consecutive = 0;
                Minus_consecutive = 0;
            }

        });

        Button R_Parenthese = new Button(")");
        root.getChildren().add(R_Parenthese);
        R_Parenthese.setLayoutX(x_pos +30);
        R_Parenthese.setLayoutY(y_pos +25);
        R_Parenthese.setOnAction(e->{

            if(R_Consecutive == 0) {
                User_equation.appendText(")");
                L_Consecutive = 0;
                R_Consecutive++;
            }

        });


        Button AC = new Button("AC");
        root.getChildren().add(AC);
        AC.setLayoutX(x_pos +70);
        AC.setLayoutY(y_pos +25);
        AC.setOnAction(e->{
            User_equation.clear();
            L_Consecutive = 0;
        });
        Scene scene = new Scene(root,400,400);



        stage.setScene(scene);
        stage.show();
        return scene;
    }


    public static void main( String[] args){
        launch(args);
    }
}

