package Stardance_Calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;




public class Main extends Application{

    @Override
    public void start(Stage stage){
        stage.setScene(Calculator_UI(stage));
    }
    public Scene Calculator_UI(Stage stage){
        GridPane root = new GridPane();
        Button one = new Button("1");
        root.add(one,1,0,4,4);

        Button two = new Button("2");
        root.add(two,2,0,4,4);

        Button three = new Button("3");
        root.add(three,1,0,4,4);

        Button four = new Button("4");
        root.add(four,1,0,3,3);

        Button five = new Button("5");
        root.add(five,2,0,3,3);

        Button six = new Button("6");
        root.add(six,3,0,3,3);

        Button seven = new Button("7");
        root.add(seven,1,0,2,2);

        Button eight = new Button("8");
        root.add(eight,2,0,2,1);

        Button nine = new Button("9");
        root.add(nine,3,0,2,2);

        Button zero = new Button("0");
        root.add(four,1,0,5,5);
        //root.add(zero,4,0,2,2);
        TextField User_equation= new TextField();
        root.getChildren().add(User_equation);

        Scene scene = new Scene(root,700,700);

        stage.setScene(scene);
        stage.show();
        return scene;
    }
    public static void main( String[] args){
        launch(args);
    }
}

