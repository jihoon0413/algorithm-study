package org.example.백준.기하_직사각형과삼각형.직사각형에서탈출_1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dots = new int[4];

        for(int i = 0 ; i < 4 ; i++){
            dots[i] = Integer.parseInt(st.nextToken());
        }

        dots[2] -= dots[0];
        dots[3] -= dots[1];


       int min = Integer.MAX_VALUE;

       for(int i = 0 ; i < 4 ; i++) {
           if(min > dots[i]) {
               min = dots[i];
           }
       }

        System.out.println(min);

    }
}
