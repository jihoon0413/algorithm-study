package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1._123더하기5_15990;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        long[][] array = new long[100001][4];

        array[1][1] = 1;
        array[2][2] = 1;
        array[3][1] = 1;
        array[3][2] = 1;
        array[3][3] = 1;


        for(int i = 4 ; i <= 100000 ; i++) {
            array[i][1] = (array[i-1][2] + array[i-1][3]) % 1000000009;
            array[i][2] = (array[i-2][1] + array[i-2][3]) % 1000000009;
            array[i][3] = (array[i-3][1] + array[i-3][2]) % 1000000009;
        }

        for(int i = 0 ; i < a ; i++) {

            int num = Integer.parseInt(br.readLine());

            long ans = (array[num][1] + array[num][2] + array[num][3]) % 1000000009;
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
