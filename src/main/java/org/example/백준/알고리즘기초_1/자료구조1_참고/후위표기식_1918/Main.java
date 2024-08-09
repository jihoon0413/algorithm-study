package org.example.백준.알고리즘기초_1.자료구조1_참고.후위표기식_1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String equ = br.readLine();

        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < equ.length() ; i++ ) {

            if('A' <= equ.charAt(i) && equ.charAt(i) <= 'Z') {
                ans.append(equ.charAt(i));
            } else {

                if (equ.charAt(i) == '(') {
                    stack.push(equ.charAt(i));
                } else if(equ.charAt(i) == ')') {
                    while (!stack.isEmpty()&& stack.peek() != '(') {
                        ans.append(stack.pop());
                    }
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }

                } else {
                    while (!stack.isEmpty() && getPriorities(stack.peek()) >= getPriorities(equ.charAt(i))) {
                        ans.append(stack.pop());
                    }
                    stack.push(equ.charAt(i));

                }
            }
        }

        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        System.out.print(ans);
    }

    static int getPriorities(char word) {

        if(word == '+' || word == '-'){
            return 1;
        } else if (word == '*' || word == '/') {
            return 2;
        }else {
            return 0;
        }

    }

}
