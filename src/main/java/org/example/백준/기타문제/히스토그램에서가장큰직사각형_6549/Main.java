package org.example.백준.기타문제.히스토그램에서가장큰직사각형_6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            if(N == 0) {
                break;
            }

            Stack<int[]> stack = new Stack<>();

            long ans = 0;

            stack.push(new int[]{0, Integer.parseInt(st.nextToken())});
            ans = stack.peek()[1];

            for(int i = 1 ; i < N ; i++) {

                int temp = Integer.parseInt(st.nextToken());

                if (stack.peek()[1] >= temp ) {
                    int[] temp2 = new int[2];
                    boolean flag = true;
                    while(stack.peek()[1] >= temp) {
                        if(stack.peek()[1] == temp) {
                            temp2 = stack.pop();
                            stack.push(new int[] {temp2[0], temp});
                            flag = false;
                            break;
                        }

                        temp2 = stack.pop();
                        long temp3 = (long) (i - temp2[0]) * temp2[1];
                        ans = Math.max(ans, temp3);

                        if(stack.isEmpty()) {
                            stack.push(new int[] {temp2[0], temp});
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        stack.push(new int[]{temp2[0], temp});
                    }
                } else {
                    stack.push(new int[] {i , temp});
                }


            }

            while(!stack.isEmpty()) {
                int[] temp = stack.pop();
                ans = Math.max(ans, (long) (N - temp[0]) *temp[1]);
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);

    }

}