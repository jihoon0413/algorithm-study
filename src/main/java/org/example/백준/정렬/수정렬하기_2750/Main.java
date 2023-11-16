package org.example.백준.정렬.수정렬하기_2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int[] array = new int[a];

        for(int i = 0 ; i < a ; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        for(int i = 0 ; i < a ; i++) {
            System.out.println(array[i]);
        }



    }
}
