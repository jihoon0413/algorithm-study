package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1_연습.동물원_1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        long[][] dp = new long[a+1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for(int i = 2; i <= a ; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] +dp[i-1][0]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;

        }

        long ans = (dp[a][0] + dp[a][1] + dp[a][2]) % 9901;

        System.out.println(ans);


    }
}
