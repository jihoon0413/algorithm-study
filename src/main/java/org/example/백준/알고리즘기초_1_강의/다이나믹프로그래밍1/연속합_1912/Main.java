package org.example.백준.알고리즘기초_1_강의.다이나믹프로그래밍1.연속합_1912;

import java.io.*;
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
            int temp = dp[i-1] + arr[i];

            if(temp > dp[i-1]) {
                dp[i] = Math.max(temp,arr[i]);
            } else {
                dp[i] = Math.max(temp,arr[i]);
            }
        }

        for(int i = 1 ; i <= a ; i++) {
            ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);

    }
}
