package org.example.do_it._4_5스택과큐._12_오큰수_17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

/**
 * 힌트 : index를 stack에 넣기
 */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];
        int[] ans = new int[N];

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < N ; i++) {
            int num = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] < num) {
                ans[stack.pop()] = num;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        for(int num : ans) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
