package org.example.백준.알고리즘기초_1.다이나믹프로그래밍1.쉬운계단수_10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        long[][] array = new long[101][10];
        long ans = 0;

        array[1][0] = 0;
        for(int i = 1 ; i <= 9 ; i++) {
            array[1][i] = 1;
        }

        for(int i = 2 ; i <= a ; i++) {
            for(int j = 0 ; j <= 9 ; j++) {
                if (j == 0) {
                    array[i][j] = array[i - 1][j + 1] % 1000000000;
                } else if (j == 9) {
                    array[i][j] = array[i - 1][j - 1] % 1000000000;
                } else {
                    array[i][j] = (array[i - 1][j - 1] + array[i-1][j + 1]) % 1000000000;
                }
            }


        }

        for(int i = 0 ; i <= 9 ; i++) {
            ans += array[a][i];
        }

        System.out.println(ans % 1000000000);

    }
}
