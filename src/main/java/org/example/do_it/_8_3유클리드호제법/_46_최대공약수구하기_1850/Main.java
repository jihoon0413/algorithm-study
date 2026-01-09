package org.example.do_it._8_3유클리드호제법._46_최대공약수구하기_1850;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        while(M % N != 0) {
            long c = M % N;
            M = N;
            N = c;
        }
        for(long i = 0 ; i < N ; i++) {
            bw.write("1");
        }
        bw.flush();
    }
}
