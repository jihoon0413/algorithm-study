package org.example.백준.알고리즘기초_1_강의.다이나믹프로그래밍1.연속합2_13398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int ans = Integer.MIN_VALUE;

        int[] arr = new int[a + 1];
        int[][] dp = new int[a + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= a ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dp[1][0] = arr[1];
        dp[1][1] = arr[1];


        for(int i = 2 ; i <= a ; i++) {
            dp[i][0] = Math.max(arr[i], dp[i-1][0] + arr[i]);
            dp[i][1] = Math.max(dp[i-2][0] + arr[i], dp[i-1][1] + arr[i]);
        }


        for (int i = 1; i <= a; i++) {
            for(int j = 0; j <= 1 ; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }
}
