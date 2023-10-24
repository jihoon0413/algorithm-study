package org.example.백준.약수배수와소수.소수찾기_1978;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);



        int a = scan.nextInt();
        int count = 0;


        for(int i = 0 ; i < a ; i++) {

            int b = scan.nextInt();
            int[] c = new int[b];
            boolean flag = true;

            if(b == 1) {
                continue;
            }

            for(int j = 2 ; j < b ; j++) {
                if(b%j == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                count++;
            }


        }
        System.out.println(count);


    }
}
