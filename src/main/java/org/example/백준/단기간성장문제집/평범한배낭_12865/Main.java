package org.example.백준.단기간성장문제집.평범한배낭_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][2];
        int[][] dp = new int[n+1][w+1];

        for(int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1; j <= w ; j++) {
                if(arr[i][0] <= j) {
                    dp[i][j] = Math.max(arr[i][1] + dp[i-1][j-arr[i][0]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }


            }
        }

//        for(int i = 1 ; i <= n ; i++) {
//            for (int j = 1; j <= w; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }


        System.out.println(dp[n][w]);

    }
}
