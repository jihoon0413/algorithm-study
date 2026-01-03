package org.example.do_it._4_5스택과큐._11_스택수열_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] goal = new int[N];

        for(int i = 0 ; i < N ; i++) {
            goal[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;
        boolean flag = true;
        for(int i = 0 ; i < N ; i++) {
            if(num <= goal[i]) {
                while(num <= goal[i]) {
                    sb.append("+\n");
                    stack.push(num++);
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if(stack.peek() != goal[i]) {
                    System.out.print("NO");
                    flag = false;
                    break;
                } else {
                    stack.pop();
                    sb.append("-\n");
                }
            }
        }
        if(flag) System.out.println(sb);
    }
}

