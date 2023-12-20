package org.example.백준.알고리즘기초_1_강의.수학1.GCD합_9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long sum = 0;
            int b = Integer.parseInt(st.nextToken());
            int[] array = new int[b];

            for(int j = 0 ; j < b ; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0 ; j < b - 1 ; j++) {
                for(int k = j + 1 ; k < b ; k++) {
                    sum += getGCD(array[j], array[k]);
                }
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
