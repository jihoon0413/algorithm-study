package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1.이친수_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        long[][] array = new long[a+1][2];

        array[1][1] = 1;

        for(int i = 2 ; i <= a ; i++) {
            array[i][0] = array[i-1][0] + array[i-1][1];
            array[i][1] = array[i-1][0];
        }

        long ans = array[a][0] + array[a][1];

        System.out.println(ans);

    }
}