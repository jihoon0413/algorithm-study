package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1.가장긴증가하는부분수열4_14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

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

        int[] ans = new int[max+1];

        int temp = max;

        while(temp != 0) {

            for(int i = a ; i > 0 ; i--) {
                if(dp[i] == temp) {
                    if(temp == max) {
                        ans[dp[i]] = array[i];
                    } else if(array[i] < ans[dp[i]+1]) {
                        ans[dp[i]] = array[i];
                    }
                }
            }

            temp--;
        }


        for(int i = 1 ; i <= max ; i++) {
            sb.append(ans[i]).append(" ");
        }


        System.out.println(max);
        System.out.println(sb);
    }
}
