package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1_연습.RGB거리2_17404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        final int max = 1000000;
        int ans = Integer.MAX_VALUE;

        int[][] arr = new int[a+1][4];
        int[][] dp = new int[a+1][4];


        StringTokenizer st;

        for (int i = 1; i <= a; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }


        for (int j = 1; j <= 3; j++) {
            for (int k = 1; k <= 3; k++) {
                if (j == k) {
                    dp[1][k] = arr[1][k];
                } else {
                    dp[1][k] = max;
                }
            }

            for (int i = 2; i <= a; i++) {
                dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][3]) + arr[i][1];
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][3]) + arr[i][2];
                dp[i][3] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][3];
            }

            for (int k = 1; k <= 3; k++) {
                if(j != k) {
                    ans = Math.min(ans, dp[a][k]);
                }
            }

        }
        System.out.println(ans);
    }
}
