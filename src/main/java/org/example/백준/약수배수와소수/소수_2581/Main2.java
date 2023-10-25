package org.example.백준.약수배수와소수.소수_2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static boolean[] prime;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int total = 0;
        int min = Integer.MAX_VALUE;

        prime = new boolean[b+1];

        getArray();

        for(int i = a ; i <= b ; i++) {
            if(!prime[i]){
                total += i;
                if(min == Integer.MAX_VALUE) min = i;
            }

        }

        if(total == 0 ) {
            System.out.println(-1);
        } else {
            System.out.println(total);
            System.out.println(min);
        }


    }


    public static void getArray() {
        prime[0] = true;
        prime[1] = true;

        for(int i = 2 ; i <= Math.sqrt(prime.length) ; i++) {
            if(prime[i]) continue;
            for(int j = i*i ; j < prime.length ; j += i) {
                prime[j] = true;
            }

        }

    }


}
