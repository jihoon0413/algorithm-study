package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1_연습.가장긴감소하는부분수열_11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int[] arr = new int[a +1];
        int[] dp = new int[a +1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= a ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= a ; i++) {
            dp[i] = 1;
            for(int j = 1 ; j < i ; j++) {
                if (arr[j] > arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i <= a ; i++) {
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);


    }
}
