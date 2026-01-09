package org.example.do_it._8_1정수론._40_소수구하기_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] num = new boolean[M+1];

        num[1] = true;
        for(int i = 2 ; i <= Math.sqrt(M) ; i++) {
            for(int j = i+i ; j <= M ; j+=i) {
                num[j] = true;
            }
        }

        for(int i = N ; i <= M ; i++) {
            if(!num[i]) {
                System.out.println(i);
            }
        }

    }
}
