package org.example.백준.알고리즘기초_1_강의.자료구조1_연습.오큰수_17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int[] num = new int[a];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < a ; i++ ){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < a ; i++ ) {

            while(!stack.isEmpty() && num[i] > num[stack.peek()] ) {
                num[stack.pop()] = num[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            num[stack.pop()] = -1;
        }

        for(int i = 0 ; i < num.length ; i++) {
            sb.append(num[i]).append(" ");
        }

        System.out.println(sb);

    }
}
