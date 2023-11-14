package org.example.백준.브루트포스.분배합_2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        int m = Integer.parseInt(num);

        System.out.println(findAns(m, num.length()));


    }

    static int findAns(int m, int length){

        for(int i = m-(length*9) ; i < m ; i++) {
            int num = i;
            int sum = 0;

            while(num != 0) {
                sum += num%10;
                num/=10;
            }

            if(sum+i == m) {
                return i;
            }

        }

        return 0;
    }
}
