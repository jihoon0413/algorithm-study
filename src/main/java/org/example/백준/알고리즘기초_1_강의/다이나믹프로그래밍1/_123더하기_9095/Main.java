package org.example.백준.알고리즘기초_1_강의.다이나믹프로그래밍1._123더하기_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] array = new int[12];

        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;

        for (int i = 4; i <= 11; i++) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];

        }

        int count = Integer.parseInt(br.readLine());

        for(int j = 0 ; j < count ; j++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(array[a]).append("\n");
        }

        System.out.println(sb);
    }
}
