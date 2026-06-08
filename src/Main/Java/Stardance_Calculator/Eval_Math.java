package Stardance_Calculator;

import java.util.ArrayList;



public class Eval_Math {


    public static String Equation(String i_equation){
        ArrayList<Character> c_equation = new ArrayList<Character>(i_equation.length());

        for(int e = 0; e < i_equation.length(); e++){
        c_equation.add(e, i_equation.charAt(e));
        }
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
                int l_number;
                int r_number;
                int operator_index = -1;

                for (int g = 0; g < p_equation.size(); g++) {
                    char r = p_equation.get(g);
                    if (r == '*' || r == '/' || r == '%') {
                        operator = r;
                         operator_index = p_equation.indexOf(r);
                        break;
                    }

                }

                l_number = Integer.valueOf(p_equation.get(operator_index-1));
                int l_index = operator_index-1;

                while((Character.isDigit(p_equation.get(l_index-1)))) {
                    l_index--;
                }

                r_number = Integer.valueOf(p_equation.get(operator_index +1));

                if(operator == '*'){
                    m_number = l_number * r_number;
                }
                if(operator == '/'){
                    m_number = l_number / r_number;
                }
                if(operator == '%'){
                    m_number = l_number * 1/100 * r_number;
                }

            }
        System.out.print(c_equation);

        return i_equation;
    }
        return i_equation;
    }}

