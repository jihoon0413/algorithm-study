package org.example.백준.알고리즘기초_1_강의.다이나믹프로그래밍1_연습.정수삼각형_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int[][] arr = new int[a+1][a+1];
        int[][] dp = new int[a+1][a+1];

        for(int i = 1 ; i <= a ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= i ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = arr[1][1];

        for(int i = 2 ; i <= a ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1] + arr[i][j],dp[i-1][j] + arr[i][j]);
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= a ; i++) {
            if(ans < dp[a][i]) {
                ans = dp[a][i];
            }
        }

        System.out.println(ans);
    }
}
