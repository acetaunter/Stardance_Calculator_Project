package Stardance_Calculator;

import java.util.ArrayList;



public class Eval_Math {


    public static String Equation(String i_equation){
        ArrayList<Character> c_equation = new ArrayList<Character>(i_equation.length());

        for(int e = 0; e < i_equation.length(); e++){
        c_equation.add(e, i_equation.charAt(e));
        }
        //substring code for the parentheses
        while(c_equation.contains("(")){
            int begin = c_equation.lastIndexOf("(");
            int b_after = begin +1;
            ArrayList<Character> p_equation = new ArrayList<Character>();
            while(c_equation.get(b_after) != ')'){
                p_equation.add(c_equation.get(b_after));
                b_after++;
            }
        System.out.println(c_equation);
            while(p_equation.contains('*') || p_equation.contains('/') || p_equation.contains('%')) {
                char operator = ' ';
                double l_number;
                double  r_number;
                double sum_number;
                int operator_index = -1;

                for (int g = 0; g < p_equation.size(); g++) {
                    char r = p_equation.get(g);
                    if (r == '*' || r == '/' || r == '%') {
                        operator = r;
                         operator_index = p_equation.indexOf(r);
                        break;
                    }

                }

                //parser logic
                int l_index = operator_index-1;
                StringBuilder sl_index = new StringBuilder("");
                while(  l_index -1>=0 && (Character.isDigit(p_equation.get(l_index-1)))) {
                    l_index--;
                    sl_index.append(p_equation.get(l_index));
                }
                sl_index.reverse();
                l_number = Double.parseDouble(String.valueOf(sl_index));

                // important note: r_index has to stop at the last number for your logic
                int r_index = operator_index+1;
                StringBuilder rl_index = new StringBuilder("");
                while(  r_index +1 <p_equation.size() && (Character.isDigit(p_equation.get(r_index+1)))){
                    r_index++;
                    rl_index.append(p_equation.get(r_index));
                    if(r_index +1 == p_equation.size()){

                    }
                }
                r_number = Double.parseDouble(String.valueOf(rl_index));

                for(int remove; remove<)
                if(operator == '*'){

                    sum_number =  r_number * l_number;
                }

                if(operator == '/'){
                    sum_number = l_number / r_number;
                }

                if(operator == '%'){
                    l_number = l_number /100.0;
                }
            }
        System.out.print(c_equation);

        return i_equation;
    }
        return i_equation;
    }}

