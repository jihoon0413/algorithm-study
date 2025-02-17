package org.example.백준.알고리즘중급_1.그리디알고리즘_도전.NMK_1201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (M + K - 1 > N || M * K < N) {
            System.out.println(-1);
            return;
        }

        int[] set = new int[M+1];

        set[1] = K;

        if(M-1 > 0) {

            int size = (N - K) / (M - 1);
            int rest = (N - K) % (M - 1);

            for (int i = 2; i <= M; i++) {

                if (rest != 0) {
                    set[i] = set[i - 1] + size + 1;
                    rest--;
                } else {
                    set[i] = set[i - 1] + size;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1 ; i <= M ; i++) {
            for (int j = set[i]; j > set[i-1] ; j--) {
                sb.append(j);
                sb.append(" ");
            }
        }

        System.out.println(sb);

    }
}
