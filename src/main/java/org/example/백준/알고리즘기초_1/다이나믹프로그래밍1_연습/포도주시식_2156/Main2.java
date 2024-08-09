package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1_연습.포도주시식_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        arr = new int[a + 1];
        dp = new Integer[a + 1];



        for(int i = 1 ; i <= a ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1];

        if(a > 1) {
            dp[2] = dp[1] + arr[2];
        }

        System.out.println(recur(a));

    }

    static int recur(int n) {

        if(dp[n] == null) {
            dp[n] = Math.max(recur(n-1),Math.max(recur(n-2) + arr[n],recur(n-3) + arr[n-1] + arr[n]));
        }

        return dp[n];

    }

}
