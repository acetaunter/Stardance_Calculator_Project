package Stardance_Calculator;

import java.util.ArrayList;



public class Eval_Math {


    public static String Equation(String i_equation){


        ArrayList<Character> c_equation = new ArrayList<>(i_equation.length());

        StringBuilder ceq = new StringBuilder( String.valueOf(c_equation));
        //creates the entire equation
        for(int e = 0; e < i_equation.length(); e++){
        c_equation.add(e, i_equation.charAt(e));
        }
        //exceptions
        if(c_equation.contains('/')){
            int o_index;
            for(int g = 0; g<c_equation.size(); g++){
                char o = c_equation.get(g);
                if( o == '/'){
                    o_index = g;
                    if(c_equation.get(o_index +1) == '0'){
                        return ("undefined");


                    }
                }

            }
        }
        //substring code for the parentheses
        while(c_equation.contains('(')){
            int begin = c_equation.lastIndexOf('(');
            int b_after = begin +1;
            int end;
            //makes the parentheses equation
            ArrayList<Character> p_equation = new ArrayList<>();

            while(c_equation.get(b_after) != ')') {
                p_equation.add(c_equation.get(b_after));
                b_after++;
            }
            //where the actual end is
                end = b_after;
        System.out.println(c_equation);
        //used for pemdas for detection if it has the first ones
            while(p_equation.contains('*') || p_equation.contains('/') || p_equation.contains('%')) {
                //all essential basic variables
                char operator = ' ';
                double l_number;
                double  r_number;
                double sum_number = 0;
                int operator_index = -1;
                //finds the operator through scanning
                for (int g = 0; g < p_equation.size(); g++) {
                    char r = p_equation.get(g);
                    if (r == '*' || r == '/' || r == '%') {
                        operator = r;
                        operator_index = g;
                        break;
                    }

                }

                //parser logic
                int l_index = operator_index-1;
                if (l_index < 0 || l_index >= c_equation.size()) {

                    break;
                }
                StringBuilder sl_index = new StringBuilder();
                sl_index.append(p_equation.get(l_index));
                while(  l_index -1>=0 && (Character.isDigit(p_equation.get(l_index-1)))) {
                    l_index--;
                    sl_index.append(p_equation.get(l_index));
                }
                sl_index.reverse();
                l_number = Double.parseDouble(String.valueOf(sl_index));

                // important note: r_index has to stop at the last number for your logic
                int r_index = operator_index+1;
                StringBuilder rl_index = new StringBuilder();
                rl_index.append(p_equation.get(r_index));
                boolean oneDot = false;
                while(  r_index +1 <p_equation.size() && (Character.isDigit(p_equation.get(r_index+1)) || p_equation.get(r_index) == '.')){
                    if(p_equation.get(r_index+1)== '*'
                            || c_equation.get(r_index+1)== '/'
                            ||c_equation.get(r_index+1)== '%'
                            ||c_equation.get(r_index+1)== '+'
                            ||c_equation.get(r_index+1)== '-' ){
                        break;
                    }
                    r_index++;
                    rl_index.append(p_equation.get(r_index));
                    if(p_equation.get(r_index) == '.'){
                        oneDot = true;
                        if(oneDot && Character.isDigit(p_equation.get(r_index+1))){
                            r_index++;
                            rl_index.append(p_equation.get(r_index));

                            continue;
                        }
                        while(Character.isDigit(p_equation.get(r_index+1))){

                            r_index++;
                            rl_index.append(c_equation.get(r_index));
                            if(oneDot == true && c_equation.get(r_index+1)== '.'){
                                break;
                            }
                        }
                    }
                }
                r_number = Double.parseDouble(String.valueOf(rl_index));

                // operator evaluation
                if(operator == '*'){
                    sum_number =  r_number * l_number;
                }


                if(operator == '/'){
                    sum_number = l_number / r_number;
                }

                if(operator == '%'){
                    sum_number = l_number /100.0;
                }
                //this must be moved
                if (r_index >= l_index) {
                    p_equation.subList(l_index, r_index + 1).clear();
                }
                StringBuilder answer = new StringBuilder(String.valueOf(sum_number));
                for(int i = 0; i < answer.length();i++){
                    p_equation.add(l_index+i,(answer.charAt(i)));
                }


                }
            while(p_equation.contains('-') || p_equation.contains('+')){
                char operator = ' ';
                double l_number;
                double  r_number;
                double sum_number = 0;
                int operator_index = -1;
                for(int g =1; g<p_equation.size(); g++ ){
                    char r = p_equation.get(g);
                    if(r == '-' || r == '+'){
                        operator = r;
                        operator_index =g;
                        break;
                    }
                }
                if(operator_index ==-1){
                    break;
                }
                //parser logic
                int l_index = operator_index-1;

                if (l_index < 0 || l_index >= c_equation.size()) {
                    System.out.println("Invalid l_index: " + l_index + " for operator at " + operator_index);
                    break;
                }
                StringBuilder sl_index = new StringBuilder();
                sl_index.append(p_equation.get(l_index));
                boolean one_dot = false;
                while(  l_index -1>=0 && (Character.isDigit(p_equation.get(l_index-1)))) {

                    if(p_equation.get(l_index+1)== '*'
                            || c_equation.get(l_index+1)== '/'
                            ||c_equation.get(l_index+1)== '%'
                            ||c_equation.get(l_index+1)== '+'
                            ||c_equation.get(l_index+1)== '-' ){
                        break;
                    }
                    l_index--;
                    sl_index.append(p_equation.get(l_index));
                    if(p_equation.get(l_index)== '.'){
                        one_dot = true;
                        if(one_dot && Character.isDigit(p_equation.get(l_index-1))){
                            l_index--;
                            sl_index.append(p_equation.get(l_index));
                            if(one_dot && p_equation.get(l_index -1)== '.'){
                                break;
                            }
                        }
                    }
                }
                sl_index.reverse();
                l_number = Double.parseDouble(String.valueOf(sl_index));

                // important note: r_index has to stop at the last number for your logic
                int r_index = operator_index+1;
                StringBuilder rl_index = new StringBuilder();
                rl_index.append(p_equation.get(r_index));
                while(  r_index +1 <p_equation.size() && (Character.isDigit(p_equation.get(r_index+1)))){
                    r_index++;
                    rl_index.append(p_equation.get(r_index));
                }
                r_number = Double.parseDouble(String.valueOf(rl_index));

                if(operator == '-'){
                    sum_number = l_number - r_number;
                }
                if(operator == '+'){
                    sum_number = l_number + r_number;
                }

                if (r_index >= l_index) {
                    p_equation.subList(l_index, r_index + 1).clear();
                }
                StringBuilder answer = new StringBuilder(String.valueOf(sum_number));
                for(int i = 0; i < answer.length();i++){
                    p_equation.add(l_index+i,(answer.charAt(i)));
                }
            }
            if (end > begin) {
                c_equation.subList(begin, end +1).clear();
            }

            for(int i =0; i<p_equation.size(); i++){
                c_equation.add(begin+i, p_equation.get(i));
            }



   }
        while(c_equation.contains('*') || c_equation.contains('/') || c_equation.contains('%')){
            double sum_number = 0;

            double l_number;
            double r_number;
            char operator = ' ';
            int operator_index = -1;

            for (int g = 0; g < c_equation.size(); g++) {

                char r = c_equation.get(g);
                if (r == '*' || r == '/' || r == '%') {
                    operator = r;

                    operator_index = g;
                    //gives the operator for outside the parentheses

                    break;



                }

            }
            if (operator_index == 0 ||
                    (!Character.isDigit(c_equation.get(operator_index - 1)) &&
                            c_equation.get(operator_index - 1) != ')')) {

                continue;
            }
            //parser logic
            int l_index = operator_index-1;

            if (l_index < 0 || l_index >= c_equation.size()) {
                System.out.println("Invalid l_index: " + l_index + " for operator at " + operator_index);
                break;
            }
            boolean L_Negative_number = false;
            if (l_index - 1 >= 0 && c_equation.get(l_index - 1) == '-') {
                L_Negative_number = true;
            }
            StringBuilder sl_index = new StringBuilder();
            if (Character.isDigit(c_equation.get(l_index)) ||
                    c_equation.get(l_index) == '.') {
                sl_index.append(c_equation.get(l_index));
            }

            System.out.println( "L_index" + l_index);
            boolean oneDot = false;
            while(  l_index -1>=0 && (Character.isDigit(c_equation.get(l_index-1)) || c_equation.get(l_index-1) == '.')) {
                if((c_equation.get(l_index-1)== '*'
                        || c_equation.get(l_index-1)== '/'
                        ||c_equation.get(l_index-1)== '%'
                        ||c_equation.get(l_index-1)== '+'
                        ||c_equation.get(l_index-1)== '-' )){
                    break;
                }
                l_index--;
                System.out.println("l_index: "+l_index);
                sl_index.append(c_equation.get(l_index));
                System.out.println("sl_index: "+sl_index);
                System.out.println("after incrementation appended" + sl_index);
                if((l_index - 1 >= 0&&c_equation.get(l_index-1) == '.' )){
                    oneDot = true;
                    if(l_index - 1 >= 0 && oneDot && Character.isDigit(c_equation.get(l_index-1))){
                        l_index--;
                        sl_index.append(c_equation.get(l_index));
                        continue;
                    }
                    while(l_index - 1 >= 0 && Character.isDigit(c_equation.get(l_index-1))){
                        l_index--;
                        sl_index.append(c_equation.get(l_index));
                        if(l_index - 1 >= 0 && oneDot && c_equation.get(l_index -1)== '.'){
                            break;
                        }
                    }


                }

            }
            sl_index.reverse();

            l_number = Double.parseDouble(String.valueOf(sl_index));

            if(L_Negative_number){
                l_number = -l_number;
            }

            if (L_Negative_number) {
                c_equation.remove(l_index - 1);
                operator_index--;
                l_index--;
            }
            System.out.println("L_number"+l_number);

            // important note: r_index has to stop at the last number for your logic
            int r_index = operator_index+1;
            StringBuilder rl_index = new StringBuilder();
            rl_index.append(c_equation.get(r_index));
            boolean one_dot = false;


            System.out.println("R_index: " + r_index);
            while(  r_index +1 <c_equation.size() && (Character.isDigit(c_equation.get(r_index+1))|| c_equation.get(r_index+1) ==  '.')){

                if(c_equation.get(r_index+1)== '*'
                        || c_equation.get(r_index+1)== '/'
                        ||c_equation.get(r_index+1)== '%'
                        ||c_equation.get(r_index+1)== '+'
                        ||c_equation.get(r_index+1)== '-' ){
                    break;
                }
                r_index++;

                rl_index.append(c_equation.get(r_index));
                System.out.println("rl_index after incrementation append"+ rl_index);
                if(c_equation.get(r_index ) == '.'){
                     one_dot = true;
                     if(one_dot && Character.isDigit(c_equation.get(r_index+1))){
                         r_index++;
                         rl_index.append(c_equation.get(r_index));

                        continue;
                     }

                while(Character.isDigit(c_equation.get(r_index+1))){

                    r_index++;
                    rl_index.append(c_equation.get(r_index));
                    if(one_dot == true && c_equation.get(r_index+1) == '.'){
                        break;
                    }
                }

                    System.out.println("decimal appended");

                }
              //where the conditional should go
                System.out.print("rl_index" + rl_index);
            }
            r_number = Double.parseDouble(String.valueOf(rl_index));



            //operator eval for full equation
            if(operator =='*'){
                sum_number = l_number * r_number;
            }

            if(operator == '/'){
                sum_number = l_number / r_number;
            }

            if(operator == '%'){
                sum_number = l_number /100.0;
            }
            if (r_index >= l_index) {
                c_equation.subList(l_index, r_index + 1).clear();
            }



            // for the final answer to return
            StringBuilder answer = new StringBuilder(String.valueOf(sum_number));
            for(int i = 0; i < answer.length();i++){
                c_equation.add(l_index+i,(answer.charAt(i)));
            }

    }
    while(c_equation.contains('+') || c_equation.contains('-') ){

        char operator = ' ';
        double  l_number;
        double  r_number;
        double sum_number = 0;
        int operator_index = -1;
        for(int g =1; g<c_equation.size(); g++ ){
            char r = c_equation.get(g);
            if(r == '-' || r == '+'){
                operator = r;
                operator_index =g;
                break;
            }
        }
        if(operator_index == -1){
            break;
        }
        if (operator_index == 0 ||
                (!Character.isDigit(c_equation.get(operator_index - 1)) &&
                        c_equation.get(operator_index - 1) != ')')) {
            operator_index++;
            continue;
        }
        //parser logic

        int l_index = operator_index-1;
        System.out.println( "l_index at the start "+c_equation.get(l_index));
        StringBuilder sl_index = new StringBuilder();

        boolean L_Negative_number = false;
        if (l_index - 1 >= 0 && c_equation.get(l_index - 1) == '-') {
                char Before_unary = 0; // zero is required for initialization
           if(l_index-2>= 0) { // verifies that theres a character before the unary
                Before_unary = c_equation.get(l_index - 2);//one before the operator to check if its unary
           }
            if(Before_unary== '-' ||
               Before_unary == '+' ||
                    Before_unary == '*' ||
                    Before_unary == '/' ||
                    Before_unary == '('

            ){
                System.out.println("negative"); // a marker for the terminal
                L_Negative_number = true; //makes it a negative
                l_index--; //adds unary
                System.out.println("after unary detection" + c_equation.get(l_index));
            }

        }
        if (l_index < 0 || l_index >= c_equation.size()) {
            System.out.println("Invalid l_index: " + l_index + " for operator at " + operator_index);
            break;
        }

        sl_index.append(c_equation.get(l_index));
        System.out.println(sl_index);
        System.out.println(l_index);
        boolean OneDot = false;

        while(  l_index-1 >= 0 && (Character.isDigit(c_equation.get(l_index-1)) || c_equation.get(l_index-1) == '.')){
            if(c_equation.get(l_index-1)== '*'
                    || c_equation.get(l_index-1)== '/'
                    ||c_equation.get(l_index-1)== '%'
                    ||c_equation.get(l_index-1)== '+'
                    ||(c_equation.get(l_index-1)== '-' && Character.isDigit(c_equation.get(l_index-2)))){
                break;
            }
           System.out.println(l_index);
           System.out.println("first number" + sl_index);
            l_index--;

            sl_index.append(c_equation.get(l_index));

            if(l_index - 1 >= 0 && c_equation.get(l_index)== '.'){
                OneDot = true;
                if(l_index - 1 >= 0 && OneDot && Character.isDigit(c_equation.get(l_index-1))){
                    l_index--;
                    sl_index.append(c_equation.get(l_index));
                    System.out.println("after decimal:" + sl_index);
                    continue;

                }
                while( l_index - 1 >= 0 && Character.isDigit(c_equation.get(l_index-1))){
                    l_index--;
                    sl_index.append(c_equation.get(l_index));
                    if(l_index - 1 >= 0 &&OneDot == true && c_equation.get(l_index-1) == '.'){
                        break;
                    }
                }
            }
        }
        System.out.println("Exited loop at index: " + l_index);
        sl_index.reverse();
        System.out.println("final index for left number" + sl_index);
        l_number = Double.parseDouble(String.valueOf(sl_index));
        if(L_Negative_number){
            l_number = -l_number;
        }
            boolean F_Negative = false;
            if (l_index == 1 && c_equation.get(0) == '-') {
                F_Negative = true;
            }
                if(F_Negative){
                l_number = -l_number;
                l_index=0;
            }
        // important note: r_index has to stop at the last number for your logic
        int r_index = operator_index+1;
        StringBuilder rl_index = new StringBuilder();
        rl_index.append(c_equation.get(r_index));
        boolean r_dot;
        System.out.println("right number at the beginning" + rl_index);
        while(  r_index +1 <c_equation.size() && (Character.isDigit(c_equation.get(r_index+1))|| c_equation.get(r_index+1) == '.')){
            if(c_equation.get(r_index+1)== '*'
                    || c_equation.get(r_index+1)== '/'
                    ||c_equation.get(r_index+1)== '%'
                    ||c_equation.get(r_index+1)== '+'
                    ||c_equation.get(r_index+1)== '-' ){
                break;
            }

            r_index++;
            System.out.println("right number before decimal" + rl_index);
            rl_index.append(c_equation.get(r_index));
            if(c_equation.get(r_index)== '.'){
                r_dot = true;
                if(r_dot && Character.isDigit(c_equation.get(r_index+1))){
                    r_index++;
                    rl_index.append(c_equation.get(r_index));
                    continue;
                }
                while(Character.isDigit(c_equation.get(r_index+1))){
                    r_index++;
                    rl_index.append(c_equation.get(r_index));
                    if(r_dot && c_equation.get(r_index+1) == '.'){
                        break;
                    }
                }
            }
        }
        r_number = Double.parseDouble(String.valueOf(rl_index));

        if(operator == '-'){
            sum_number = l_number - r_number;
        }
        if(operator == '+'){
            System.out.println("addition");
            System.out.println(l_number+" =left number");
            System.out.println(r_number + " =right number");
            sum_number = l_number + r_number;

        }

        if (r_index >= l_index) {
            c_equation.subList(l_index, r_index + 1).clear();
        }
        StringBuilder answer = new StringBuilder(String.valueOf(sum_number));
        for(int i = 0; i < answer.length();i++){
            c_equation.add(l_index+i,(answer.charAt(i)));
        }

    }
    StringBuilder final_answer = new StringBuilder();
        for(int i = 0; i< c_equation.size() ; i++){
            final_answer.append(c_equation.get(i));
        }

        return final_answer.toString();

    }}

