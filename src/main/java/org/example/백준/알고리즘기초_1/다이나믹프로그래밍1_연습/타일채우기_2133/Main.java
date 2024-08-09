package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1_연습.타일채우기_2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int[] dp = new int[a + 1];

        dp[0] = 1;

        for(int i = 2 ; i <= a ; i++) {
            dp[i] = dp[i-2] * 3;

            for(int j = i-4 ; j >= 0 ; j-=2) {
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[a]);
    }
}
