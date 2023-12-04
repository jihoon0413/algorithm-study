package org.example.백준.알고리즘기초_1_강의.자료구조1.스택수열_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int c = 1;
        boolean flag = true;

        for (int i = 1; i <= a; i++) {
            int b = Integer.parseInt(br.readLine());


            while (stack.empty() || b != stack.peek()) {

                if (c > a) {

                    flag = false;
                    break;
                }
                stack.push(c);
                sb.append("+").append("\n");
                c++;
            }

            if (!flag) {
                break;
            }

            if (b == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
            }
        }
        if (!flag) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
