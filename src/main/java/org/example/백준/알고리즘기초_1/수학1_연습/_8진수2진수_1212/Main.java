package org.example.백준.알고리즘기초_1.수학1_연습._8진수2진수_1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            int a = Integer.parseInt(String.valueOf(input.charAt(i)));

            for (int j = 0; j < 3; j++) {
                stack.push(a % 2);
                a /= 2;
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }

        int index = 0;
        while (sb.charAt(0) == '0') {
            index++;
            if (index == 3) {
                break;
            }
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }
}
