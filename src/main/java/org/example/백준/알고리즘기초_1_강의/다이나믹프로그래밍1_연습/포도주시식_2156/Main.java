package org.example.백준.알고리즘기초_1_강의.다이나믹프로그래밍1_연습.포도주시식_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a + 1];
        int[][][] dp = new int[a+1][2][3];


        for(int i = 1 ; i <= a ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        dp[1][0][0] = 0;
        dp[1][1][1] = arr[1];


        for(int i = 2 ; i <= a ; i++) {
            dp[i][0][0] = Math.max(dp[i-1][0][0],Math.max(dp[i-1][1][1],dp[i-1][1][2]));
            dp[i][1][1] = dp[i-1][0][0] + arr[i];
            dp[i][1][2] = dp[i-1][1][1] + arr[i];
        }



        System.out.println(Math.max(dp[a][0][0],Math.max(dp[a][1][1],dp[a][1][2])));

    }
}
