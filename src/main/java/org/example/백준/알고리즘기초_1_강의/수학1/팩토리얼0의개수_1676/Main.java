package org.example.백준.알고리즘기초_1_강의.수학1.팩토리얼0의개수_1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        double b = 1;
        int count = 0;

        while(a >= 5) {
            count += a/5;
            a /= 5;
        }

        System.out.println(count);

    }
}
