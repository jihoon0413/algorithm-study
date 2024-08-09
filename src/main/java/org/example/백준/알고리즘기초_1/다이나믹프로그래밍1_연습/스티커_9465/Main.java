package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1_연습.스티커_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[3][n+1];

            for(int j = 1 ; j <= 2 ; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 1 ; k <= n ; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[3][n+1];
            dp[0][1] = 0;
            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];

            for(int j = 2 ; j <= n ; j++) {
                dp[0][j] = Math.max(dp[1][j-1],dp[2][j-1]);
                dp[1][j] = Math.max(dp[0][j-1] + arr[1][j],dp[2][j-1] + arr[1][j]);
                dp[2][j] = Math.max(dp[0][j-1] + arr[2][j],dp[1][j-1] + arr[2][j]);
            }

            int ans = Math.max(dp[0][n],Math.max(dp[1][n],dp[2][n]));
            sb.append(ans).append("\n");
        }
        
        System.out.println(sb);
    }
}
