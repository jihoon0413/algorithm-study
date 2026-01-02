package org.example.do_it._4_3투포인터._6_연속된자연수합구하기_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 1;

        int N = Integer.parseInt(br.readLine());

        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;

        while(endIdx != N) {
            if(sum == N) {
                answer++;
                endIdx++;
                sum += endIdx;
            } else if(sum < N) {
                endIdx++;
                sum += endIdx;
            } else {
                sum -= startIdx;
                startIdx++;
            }
        }

        System.out.println(answer);

    }
}