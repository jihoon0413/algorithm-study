package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1_연습.연속합2_13398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int ans = Integer.MIN_VALUE;

        int[] arr = new int[a + 1];
        int[] dpF = new int[a + 1];
        int[] dpB = new int[a + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= a ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dpF[1] = arr[1];
        for(int i = 2; i <= a ; i++) {
            dpF[i] = Math.max(arr[i],  dpF[i-1] + arr[i]);
            ans = Math.max(ans, dpF[i]);
        }

        dpB[a] = arr[a];
        for(int i = a-1; i > 0 ; i--) {
            dpB[i] = Math.max(arr[i], dpB[i+1] + arr[i]);
        }

        for(int i = 2 ; i < a ; i++) {
            int temp = dpF[i-1] + dpB[i+1];
            System.out.println(i + " : " + temp);
            ans = Math.max(ans,temp);
        }

        System.out.println(ans);
    }
}
