package org.example.백준.약수배수와소수.소수_2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int total = 0;
        int min = Integer.MAX_VALUE;

        for (int i = a ; i <= b ; i++) {

            if(i == 1) {
                continue;
            }

            if(check(i)) {
                if(min == Integer.MAX_VALUE ) min = i;
                total += i;
            };



        }

        if(total == 0 ) {
            System.out.println(-1);
        } else {
            System.out.println(total);
            System.out.println(min);
        }


    }


    private static boolean check(int num) {

        boolean flag = true;

        for(int i = 2 ; i <= Math.sqrt(num) ; i++) {

           if(num%i == 0 ) {
               flag = false;
               break;
           }
        }

        return flag;
    }

}
