package org.example.do_it._8_2오일러피._44_오일러피함수_11689;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long result = N;

        for(int i = 2 ; i <= Math.sqrt(N) ; i++) {
            if(N % i == 0) {
                result = result - result/i;
                while(N % i == 0) {
                    N /= i;
                }
            }
        }

        if(N > 1) {
            result = result - result/N;
        }

        System.out.println(result);

    }
}
