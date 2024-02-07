package org.example.백준.알고리즘기초_1_강의.다이나믹프로그래밍1.카드구매하기_11052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int[] price = new int[a+1];
        int[] answer = new int[a+1];
        price[0] = answer[0] = 0;


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= a ; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        answer[1] = price[1];

        for(int i = 2 ; i <= a ; i++) {
            for (int j = 1 ; j <= i; j++) {
                answer[i] = Math.max(answer[i], answer[i - j] + price[j]);
            }
        }

        System.out.println(answer[a]);

    }

}
