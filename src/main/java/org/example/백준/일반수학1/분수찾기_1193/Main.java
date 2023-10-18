package org.example.백준.일반수학1.분수찾기_1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int range = 2;
        int count = 2;
        int preRange = 0;

        if(a == 1) {
            System.out.println("1/1");
        } else {
            while(a >= range) {
                preRange = range;
                range += count;
                count++;
            }

            int c = 1;
            int p = count-1;

            for(int i = 0 ; i < a-preRange; i++) {

                c += 1;
                p -= 1;

            }

            if((count-1)%2 == 0) {
                System.out.println(c +"/" + p);
            } else {
                System.out.println(p +"/" + c);
            }

        }

    }
}
