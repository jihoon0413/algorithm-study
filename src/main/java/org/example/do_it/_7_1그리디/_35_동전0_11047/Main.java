package org.example.do_it._7_1그리디._35_동전0_11047;

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
        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while(M!=0) {

            for(int i = N-1 ; i >= 0 ; i--) {
                if(M / arr[i] >= 1) {
                    answer += M/arr[i];
                    M %= arr[i];
                }
            }
        }

        System.out.println(answer);

    }
}
