package org.example.백준.기타문제.히스토그램에서가장큰직사각형_6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {
        public static int[] histogram;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N;

        while (true) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            }

            histogram = new int[N];
            for (int i = 0; i < N; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(solve(N)).append("\n");
        }
        System.out.println(sb);

    }
    static long solve ( int len){
        Stack<Integer> stack = new Stack<>();

        long ans = 0;

        for (int i = 0; i < len; i++) {

            while ((!stack.isEmpty()) && histogram[stack.peek()] >= histogram[i]) {
                int height = histogram[stack.pop()];

                long width = stack.isEmpty() ? i : i - 1 - stack.peek();

                ans = Math.max(ans, height * width);

            }

            stack.push(i);

        }

        while (!stack.isEmpty()) {
            int height = histogram[stack.pop()];
            long width = stack.isEmpty() ? len : len - 1 - stack.peek();
            ans = Math.max(ans, height * width);
        }

        return ans;

    }

}
