package org.example.백준.알고리즘기초_1_강의.다이나믹프로그래밍1_연습._123더하기3_15988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < count ; i++) {

            int a = Integer.parseInt(br.readLine());

            long[] dp = new long[a+1];

            dp[1] = 1;

            for(int j = 2; j <= a ; j++) {
//                if(j == 1) {
//                    dp[j] = 1;
//                } else if (j == 2) {
//                    dp[j] = 2;
//                } else if (j == 3) {
//                    dp[j] = 4;
//                } else {
//                    dp[j] = (dp[j-1] + dp[j-2] + dp[j-3]) % 1000000009;
//                }

               if (j-2 <= 0) {
                   dp[j] = (dp[j-1] + 1)% 1000000009;
               } else if (j-3 <= 0) {
                   dp[j] = (dp[j-1] + dp[j-2] + 1)%1000000009;
               } else {
                   dp[j] = (dp[j-1] + dp[j-2] + dp[j-3])%1000000009;
               }


            }
            sb.append(dp[a]).append("\n");
        }

        System.out.println(sb);
    }
}
