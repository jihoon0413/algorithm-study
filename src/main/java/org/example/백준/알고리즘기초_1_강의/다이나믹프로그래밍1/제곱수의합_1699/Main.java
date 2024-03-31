package org.example.백준.알고리즘기초_1_강의.다이나믹프로그래밍1.제곱수의합_1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int[] dp = new int[a + 1];

        long startTime = System.nanoTime();

        for (int i = 1; i <= a; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                int temp = dp[i - j * j] + 1;
                if (dp[i] > temp) {
                    dp[i] = temp;
                }
            }
        }

        long endTime = System.nanoTime();

        double elapsedTime = (endTime - startTime)/1000000.0;

        System.out.println("nano="+elapsedTime);

        System.out.println(dp[a]);
    }
}

//        int a = Integer.parseInt(br.readLine());
//        int count = 0;
//
//
//        long startTime = System.nanoTime();
//
//        while (a != 0) {
//            int temp  = (int) Math.sqrt(a);
//
//            count++;
//            a -= (int) Math.pow(temp,2);
//        }
//
//        long endTime = System.nanoTime();
//
//        double elapsedTime = (endTime - startTime)/1000000.0;
//
//        System.out.println("nano="+elapsedTime);
//
//        System.out.println(count);
//    }
//}
