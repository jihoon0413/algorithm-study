package org.example.백준.알고리즘기초_2_강의.브루트포스.수이어쓰기1_1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a = Long.parseLong(br.readLine());

        int count = 0;
        int set = 1;
        int ten = 10;


        for(int i = 1; i <= a ; i++) {

            if(i % ten == 0) {
                set++;
                ten *= 10;
            }

            count += set;
        }
        System.out.println(count);


    }
}
