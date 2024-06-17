package org.example.백준.기타문제.히스토그램_1725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<int[]> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        stack.push(new int[]{0, Integer.parseInt(br.readLine())});
        ans = stack.peek()[1];

        for(int i = 1 ; i < N ; i++) {

            int temp = Integer.parseInt(br.readLine());

            if (stack.peek()[1] >= temp ) {
                int[] temp2 = new int[0];
                while(stack.peek()[1] >= temp) {
                    if(stack.peek()[1] == temp) {
                        temp2 = stack.pop();
                        stack.push(new int[] {temp2[0], temp});
                        break;
                    }

                    temp2 = stack.pop();
                    int temp3 = (i-temp2[0]) * temp2[1];
                    ans = Math.max(ans, temp3);

                    if(stack.isEmpty()) {
                        stack.push(new int[] {temp2[0], temp});
                        break;
                    }
                }
                stack.push(new int[] {temp2[0], temp});
            } else {
                stack.push(new int[] {i , temp});
            }


        }

        while(!stack.isEmpty()) {
            int[] temp = stack.pop();
            ans = Math.max(ans, (N-temp[0])*temp[1]);
        }
        System.out.println(ans);




//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        int[] height = new int[N+2];
//
//        long answer = 0;
//        Stack<Integer> stack = new Stack<>();
//
//        height[0] = 0;
//        height[N] = 0;
//
//        for(int i = 1; i <= N; i++)
//            height[i] = Integer.parseInt(br.readLine());
//
//        stack.push(0);
//
//        for(int i = 1; i <= N+1; i++) {
//            while(!stack.isEmpty()) {
//                int top = stack.peek();
//
//                if(height[top] <= height[i])
//                    break;
//
//                stack.pop();
//                answer = Math.max(answer, (long) height[top] * (i-stack.peek()-1));
//            }
//
//            stack.push(i);
//        }
//
//        System.out.println(answer);

    }
}