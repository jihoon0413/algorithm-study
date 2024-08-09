package org.example.백준.알고리즘기초_1.자료구조1_연습.단어뒤집기2_17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sentence = br.readLine();
        boolean flag = true;
        Stack<Character> stack = new Stack<>();



        for(int i = 0 ; i < sentence.length() ; i++) {

            if(sentence.charAt(i) == '<') {
                flag = false;
            }

            if(flag) {
                if(sentence.charAt(i) == ' ') {
                    int size = stack.size();
                    for(int j = 0 ; j < size ; j++) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                } else {
                    stack.push(sentence.charAt(i));
                }
            } else {
                int size = stack.size();
                for(int j = 0 ; j < size ; j++) {
                    sb.append(stack.pop());
                }

                while (sentence.charAt(i) != '>') {
                    sb.append(sentence.charAt(i));
                    i++;
                }
                sb.append('>');
                flag = true;
            }
        }

        if(!stack.isEmpty()) {
            int size = stack.size();
            for(int j = 0 ; j < size ; j++) {
                sb.append(stack.pop());
            }
        }

        System.out.println(sb);

    }
}
