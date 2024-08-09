package org.example.백준.알고리즘기초_1.수학1_연습.마이너스2진수_2089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Long> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

//        long a = Long.parseLong(br.readLine());
//
//        if(a != 0) {
//            while (a != 1) {
//                if (a < 0) {
//                    stack.push(Math.abs(a % -2));
//                    if(a % -2 == 0) {
//                        a /= -2;
//                    } else {
//                        a = a / -2 + 1;
//                    }
//                } else {
//                    stack.push(a % -2);
//                    a /= -2;
//                }
//            }
//        }
//
//        stack.push(a);
//
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//        System.out.println(sb);

        long a = Long.parseLong(br.readLine());

        if(a != 0) {
            while (a != 1) {
                    stack.push(Math.abs(a % -2));

                    a = (long) Math.ceil((double) a / -2);

            }
        }

        stack.push(a);

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);

    }
}
