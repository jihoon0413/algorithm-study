package org.example.백준.일반수학1.벌집_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int ans = 1;
        int range = 2;


        if(a == 1) {
            System.out.println(1);
        } else {
            while(range <= a) {
                range = range + (6*ans);
                ans++;
            }
            System.out.println(ans);
        }



    }
}
