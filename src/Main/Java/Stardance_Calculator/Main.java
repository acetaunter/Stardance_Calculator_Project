package Stardance_Calculator;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;


public class Main extends Application{
    // 25 pixel incremental for x direction
    int y_pos = 0;
    int x_pos = 130;
    int counter = 0;
    @Override
    public void start(Stage stage){
        stage.setScene(Calculator_UI(stage));
    }
    public Scene Calculator_UI(Stage stage){
        Pane root = new Pane();
        TextField User_equation= new TextField();
       User_equation.setLayoutX(130);
       User_equation.setLayoutY(0);
        root.getChildren().add(User_equation);

        Button one = new Button("1");
        one.setLayoutX(x_pos +10);
        one.setLayoutY(y_pos +75);
        root.getChildren().add(one);
        one.setOnAction(e->{
            User_equation.appendText("1");
            counter++;
        });

        Button two = new Button("2");
        two.setLayoutX(x_pos +30);
        two.setLayoutY(y_pos +75);
        root.getChildren().add(two);
        two.setOnAction(e->{
            User_equation.appendText("2");
            counter++;
        });


        Button three = new Button("3");
        three.setLayoutX(x_pos +50);
        three.setLayoutY(y_pos +75);
       root.getChildren().add(three);
        three.setOnAction(e->{
            User_equation.appendText("3");
            counter++;
        });

        Button four = new Button("4");
        four.setLayoutX(x_pos+10);
        four.setLayoutY(y_pos +50);
        root.getChildren().add(four);
        four.setOnAction(e->{
            User_equation.appendText("4");
            counter++;
        });


        Button five = new Button("5");
        five.setLayoutX(x_pos +30);
        five.setLayoutY(y_pos +50);
        root.getChildren().add(five);
        five.setOnAction(e->{
            User_equation.appendText("5");
            counter++;
        });


        Button six = new Button("6");
        six.setLayoutX(x_pos +50);
        six.setLayoutY(y_pos +50);
        root.getChildren().add(six);
        six.setOnAction(e->{
            User_equation.appendText("6");
            counter++;
        });

        Button seven = new Button("7");
        seven.setLayoutX(x_pos +10);
        seven.setLayoutY(y_pos +25);
        root.getChildren().add(seven);
        seven.setOnAction(e->{
            User_equation.appendText("7");
            counter++;
        });

        Button eight = new Button("8");
        eight.setLayoutX(x_pos +30);
        eight.setLayoutY(y_pos +25);
        root.getChildren().add(eight);
        eight.setOnAction(e->{
            User_equation.appendText("8");
            counter++;
        });

        Button nine = new Button("9");
        nine.setLayoutX(x_pos +50);
        nine.setLayoutY(y_pos +25);
        root.getChildren().add(nine);
        nine.setOnAction(e->{
            User_equation.appendText("9");
            counter++;
        });

        Button zero = new Button("0");
        zero.setLayoutX(x_pos +10);
        zero.setLayoutY(y_pos +100);
        root.getChildren().add(zero);
        zero.setOnAction(e->{
            User_equation.appendText("0");
            counter++;
        });

        //operations code
        Button plus = new Button("+");
        root.getChildren().add(plus);
        plus.setLayoutX(x_pos +70);
        plus.setLayoutY(y_pos +100);
        plus.setOnAction(e->{
            User_equation.appendText("+");
            counter++;
        });


        Button minus = new Button("-");
        root.getChildren().add(minus);
        minus.setLayoutX(x_pos +70);
        minus.setLayoutY(y_pos +75);
        minus.setOnAction(e->{
            User_equation.appendText("-");
            counter++;
        });

        Button multi = new Button("*");
        root.getChildren().add(multi);
        multi.setLayoutX(x_pos +70);
        multi.setLayoutY(y_pos +50);
        multi.setOnAction(e->{
            User_equation.appendText("*");
            counter++;
        });

        Button divide = new Button("/");
        root.getChildren().add(divide);
        divide.setLayoutX(x_pos +70);
        divide.setLayoutY(y_pos +25);
        divide.setOnAction(e->{
            User_equation.appendText("/");
            counter++;
        });

        //
        Button decimal = new Button(".");
        root.getChildren().add(decimal);
        decimal.setLayoutX(30);
        decimal.setLayoutY(30);


        Button equals = new Button("=");
        root.getChildren().add(equals);

        equals.setOnAction(e->{
            ArrayList<String> equation = new ArrayList<>(Collections.singleton(User_equation.getText()));
            System.out.print(equation);
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

