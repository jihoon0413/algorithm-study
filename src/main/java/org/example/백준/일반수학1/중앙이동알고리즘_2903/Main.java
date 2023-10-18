package org.example.백준.일반수학1.중앙이동알고리즘_2903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int s = 2;

        for(int i = 1 ; i <= a ; i++) {
            s = s+(s-1);
        }
        System.out.println((int)Math.pow(s,2));

//        System.out.println((int)Math.pow(Math.pow(2, a) +1, 2));
    }
}
