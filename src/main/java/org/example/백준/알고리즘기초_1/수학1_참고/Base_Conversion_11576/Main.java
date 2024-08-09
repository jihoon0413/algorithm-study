package org.example.백준.알고리즘기초_1.수학1_참고.Base_Conversion_11576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());


        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int sum = 0;

        for (int j = count-1; j >= 0; j--) {
            sum += Integer.parseInt(st.nextToken()) * Math.pow(a, j);
        }

        while (sum != 0 ) {
            stack.push(sum % b);
            sum /= b;
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);


    }
}
