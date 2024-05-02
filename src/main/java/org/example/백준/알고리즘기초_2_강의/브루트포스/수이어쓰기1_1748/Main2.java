package org.example.백준.알고리즘기초_2_강의.브루트포스.수이어쓰기1_1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a = Long.parseLong(br.readLine());

        System.out.println(solve(a));


    }
    static long solve(long a) {
        long ans = 0;
        int temp = 0;

        while (a >= Math.pow(10,temp)) {
            temp++;
        }

        temp--;

        while (temp >= 0) {
            ans += (long) ((a - Math.pow(10,temp) + 1) * (temp+1));
            a = (long) Math.pow(10,temp)-1;
            temp--;
        }

        return ans;
    }
}