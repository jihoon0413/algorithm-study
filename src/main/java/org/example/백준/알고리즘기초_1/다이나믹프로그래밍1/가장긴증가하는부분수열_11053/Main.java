package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1.가장긴증가하는부분수열_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int[] array = new int[a+1];
        int[] dp = new int[a+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= a ; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= a; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 1;
        for(int i : dp) {
            max = Math.max(i,max);
        }

        System.out.println(max);

    }
}
