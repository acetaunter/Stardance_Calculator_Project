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
                while(  r_index +1 <p_equation.size() && (Character.isDigit(p_equation.get(r_index+1)))){
                    r_index++;
                    rl_index.append(p_equation.get(r_index));
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
                for(int g =0; g<p_equation.size(); g++ ){
                    char r = p_equation.get(g);
                    if(r == '-' || r == '+'){
                        operator = r;
                        operator_index =g;
                        break;
                    }
                }

                //parser logic
                int l_index = operator_index-1;
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
            //parser logic
            int l_index = operator_index-1;
            StringBuilder sl_index = new StringBuilder();
            sl_index.append(c_equation.get(l_index));
            while(  l_index -1>=0 && (Character.isDigit(c_equation.get(l_index-1)))) {
                l_index--;
                sl_index.append(c_equation.get(l_index));
            }
            sl_index.reverse();
            l_number = Double.parseDouble(String.valueOf(sl_index));

            // important note: r_index has to stop at the last number for your logic
            int r_index = operator_index+1;
            StringBuilder rl_index = new StringBuilder();
            rl_index.append(c_equation.get(r_index));
            while(  r_index +1 <c_equation.size() && (Character.isDigit(c_equation.get(r_index+1)))){
                r_index++;
                rl_index.append(c_equation.get(r_index));
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
    while(c_equation.contains('+') || c_equation.contains('-')){
        char operator = ' ';
        double l_number;
        double  r_number;
        double sum_number = 0;
        int operator_index = -1;
        for(int g =0; g<c_equation.size(); g++ ){
            char r = c_equation.get(g);
            if(r == '-' || r == '+'){
                operator = r;
                operator_index =g;
                break;
            }
        }

        //parser logic
        int l_index = operator_index-1;
        StringBuilder sl_index = new StringBuilder();
        sl_index.append(c_equation.get(l_index));
        System.out.println(l_index);
        boolean dec;
        while(  l_index-1 >= 0 && (Character.isDigit(c_equation.get(l_index-1)) || c_equation.get(l_index-1) == '.')){
           System.out.println(l_index);

            l_index--;
            sl_index.append(c_equation.get(l_index));
        }
        System.out.println("Exited loop at index: " + l_index);
        sl_index.reverse();
        l_number = Double.parseDouble(String.valueOf(sl_index));

        // important note: r_index has to stop at the last number for your logic
        int r_index = operator_index+1;
        StringBuilder rl_index = new StringBuilder();
        rl_index.append(c_equation.get(r_index));
        while(  r_index +1 <c_equation.size() && (Character.isDigit(c_equation.get(r_index+1)))){
            r_index++;
            rl_index.append(c_equation.get(r_index));
        }
        r_number = Double.parseDouble(String.valueOf(rl_index));

        if(operator == '-'){
            sum_number = l_number - r_number;
        }
        if(operator == '+'){
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

