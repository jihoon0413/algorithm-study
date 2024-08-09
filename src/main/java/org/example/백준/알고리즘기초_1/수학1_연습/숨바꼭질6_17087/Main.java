package org.example.백준.알고리즘기초_1.수학1_연습.숨바꼭질6_17087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] array = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            array[i] = Math.abs(s - Integer.parseInt(st2.nextToken()));
        }

        int a = array[0];
        for(int i = 0 ; i < n ; i++ ) {
            if(a > array[i] || array[i] % a != 0 ) {
                a = getGCD(a,array[i]);
            }
        }
        System.out.println(a);


    }

    static int getGCD(int a, int b) {

        if(a < b) {
            int temp = b;
            b = a;
            a = temp;
        }

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
