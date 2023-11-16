package org.example.백준.브루트포스.설탕배달_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int count = Integer.MAX_VALUE;


        for(int i = 1 ; i <= a/5 ; i++) {
            if((a - 5*i)% 3 == 0) {
                int temp = i + (a - 5*i)/3;
                if(count > temp) {
                    count = temp;
                }
            }
        }


        if(a%3 == 0) {
            if(count > a/3) {
                count = a/3;
            };
        }

        if(count == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(count);
        }

    }
}
