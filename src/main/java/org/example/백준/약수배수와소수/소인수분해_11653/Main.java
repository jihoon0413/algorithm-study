package org.example.백준.약수배수와소수.소인수분해_11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = a;

        for(int i = 2 ; i <=Math.sqrt(a) ; i++) {

//            if(a%i == 0 ) {
//                a /= i;
//                System.out.println(i);
//                i--;
//            }
            while (a%i == 0) {
                a /= i;
                System.out.println(i);
            }

        }

    }
}
