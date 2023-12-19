package org.example.백준.알고리즘기초_1_강의.수학1.골드바흐의추측_6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] array = new boolean[1000001];

        array[0] = false;
        array[1] = false;
        for(int i = 2 ; i < 1000001 ; i++) {
            array[i] = true;
        }

        for(int i = 2 ; i < Math.sqrt(1000001) ; i++) {
            int num = 2;
            while (i*num < 1000001) {
                array[i*num] = false;
                num++;
            }
        }

        while(true) {
            int a = Integer.parseInt(br.readLine());

            if(a == 0) {
                break;
            } else {
                for(int i = 2 ; i < a ; i++) {
                    if(array[i] && array[a-i]) {
                        System.out.println(a + " = " + i + " + " + (a-i));
                        break;
                    }
                }
            }
        }
    }
}
