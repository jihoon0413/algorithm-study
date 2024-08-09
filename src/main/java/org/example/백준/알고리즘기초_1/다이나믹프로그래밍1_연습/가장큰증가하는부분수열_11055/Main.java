package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1_연습.가장큰증가하는부분수열_11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int[] arr = new int[a+1];
        int[] dp = new int[a+1];
        int ans = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= a ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];

        for(int i = 2 ; i <= a ; i++) {
            dp[i] = arr[i];
            for(int j = 1 ; j < i ; j++) {
                if(arr[i]> arr[j]) {
                    dp[i] = Math.max(dp[j]+arr[i],dp[i]);
                }
            }
        }

        for(int i = 1 ; i <= a ; i++) {
            ans = Math.max(ans,dp[i]);
        }

        System.out.println(ans);
    }
}
