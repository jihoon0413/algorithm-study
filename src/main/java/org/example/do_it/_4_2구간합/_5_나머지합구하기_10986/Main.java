package org.example.do_it._4_2구간합._5_나머지합구하기_10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long[] reminder = new long[M];


        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i < N ; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < N ; i++) {
            int temp = (int) (arr[i] % M);

            if( temp == 0) {
                answer ++;
            }

            reminder[temp]++;
        }

        for(int i = 0 ; i < M ; i++) {
            if(reminder[i] > 1) {
                answer = answer + (reminder[i] * (reminder[i] - 1 ) / 2);
            }
        }
        System.out.println(answer);

    }
}