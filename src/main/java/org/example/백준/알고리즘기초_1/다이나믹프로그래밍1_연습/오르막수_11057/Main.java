package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1_연습.오르막수_11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int[][] dp = new int[a+1][10];
        int ans = 0;

        for(int i = 0 ; i < 10 ; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2 ; i <= a ; i++) {

            for(int j = 0 ; j <= 9 ; j++) {
                int temp = 0;
                for(int k = 0 ; k <= j ; k++) {
                    temp += dp[i - 1][k] % 10007;

                }
                dp[i][j] = temp % 10007;
            }

        }

        for(int i = 0 ; i < 10 ; i++) {
            ans += dp[a][i];
        }

        System.out.println(ans % 10007);
    }
}
