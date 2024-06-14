package org.example.백준.기타문제.탑_2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<int[]> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i  = 1 ; i <= N ; i++) {

            int top = Integer.parseInt(st.nextToken());

            while(true) {
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                    stack.push(new int[]{i, top});
                    break;
                } else {
                    if (stack.peek()[1] >= top) {
                        sb.append(stack.peek()[0]).append(" ");
                        stack.push(new int[]{i, top});
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
