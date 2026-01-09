package org.example.do_it._8_1정수론._43_제곱아닌수_1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        int total = (int) (M - N + 1);

        boolean[] check = new boolean[total];

        for(long i = 2 ; i * i <= M ; i++) {
            long temp = i*i;
            long start_idx = N / temp;
            if(N%temp != 0) start_idx++;

            for(long j = start_idx ; temp * j <= M ; j++) {
                check[(int)((temp * j) -N)] = true;
            }

        }
        for(boolean flag : check) {
            if(!flag) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}