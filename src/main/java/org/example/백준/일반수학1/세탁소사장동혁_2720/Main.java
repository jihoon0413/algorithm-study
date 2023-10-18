package org.example.백준.일반수학1.세탁소사장동혁_2720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++) {
            int b = Integer.parseInt(br.readLine());
            cal(b);
            System.out.println();
        }
    }

    public static void cal(int money) {
        int[] c = new int[] {25, 10, 5, 1};

        for(int i = 0 ; i < 4 ; i++) {
            System.out.print(money / c[i] + " ");
            money %= c[i];
        }
    }

}
