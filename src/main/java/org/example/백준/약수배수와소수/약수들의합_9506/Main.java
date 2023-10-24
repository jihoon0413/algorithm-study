package org.example.백준.약수배수와소수.약수들의합_9506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                int a = Integer.parseInt(br.readLine());

                if(a == -1) {
                    break;
                }

                int[] b = new int[a];
                int count = 0;
                int total = 0;



                for (int i = 1; i < a; i++) {
                    if (a % i == 0) {
                        total += i;
                        b[count++] = i;
                    }
                }

                if (total == a) {
                    System.out.print(a + " = 1");
                    for (int i = 1; i < count; i++) {

                        System.out.print(" + " + b[i]);
                    }
                    System.out.println();
                } else {
                    System.out.println(a + " is NOT perfect.");
                }
            }

    }
}
