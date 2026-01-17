package org.example.do_it._11_1조합알아보기._80_이항계수구하기2_11051;

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

        int[][] D = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++) {
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = i;
        }

        for(int i = 2 ; i <= N ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                D[i][j] = (D[i-1][j] + D[i-1][j-1]) % 10007;
            }
        }

        System.out.println(D[N][M]);

    }
}

