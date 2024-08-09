package org.example.백준.알고리즘기초_1.자료구조1_참고.후위표기식2_1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int count = Integer.parseInt(br.readLine());

        double[] num = new double[count];

        String equ = br.readLine();

        for(int i = 0 ; i < count ; i++) {
            num[i] = Double.parseDouble(br.readLine());
        }

        for(int i = 0 ; i < equ.length(); i++) {

            if('A' <= equ.charAt(i) && equ.charAt(i) <= 'Z') {
                stack.push(num[equ.charAt(i) - 65]);
            }else if(equ.charAt(i) == '+' || equ.charAt(i) == '-' || equ.charAt(i) == '*' || equ.charAt(i) == '/' ) {

                double b;
                double a;

                switch (equ.charAt(i)) {
                    case '+':
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a + b);
                        break;

                    case '-':
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a - b);
                        break;

                    case '*':
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a * b);
                        break;

                    case '/':
                        b = stack.pop();
                        a = stack.pop();
                        stack.push(a / b);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
