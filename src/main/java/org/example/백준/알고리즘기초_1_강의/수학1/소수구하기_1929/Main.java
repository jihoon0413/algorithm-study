package org.example.백준.알고리즘기초_1_강의.수학1.소수구하기_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] arrays = new boolean[b+1];

        arrays[0] = false;
        arrays[1] = false;

        for(int i = 2 ; i < b+1 ; i++) {
            arrays[i] = true;
        }

        for(int i = 2 ; i < b+1 ; i++) {
           if(arrays[i]) {
               int num = 2;
               while (i*num <= b) {
                   arrays[i*num] = false;
                   num++;
               }

           }
        }

        for(int i = a ; i <= b ; i++) {
            if(arrays[i]) {
                System.out.println(i);
            }
        }
    }
}
