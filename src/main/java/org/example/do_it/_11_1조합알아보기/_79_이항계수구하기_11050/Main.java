package org.example.do_it._11_1조합알아보기._79_이항계수구하기_11050;

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

        int[][] D = new int[11][11];

        for(int i = 1 ; i < 11 ; i++) {
            D[i][1] = i;
            D[i][i] = 1;
            D[i][0] = 1;
        }

        for(int i = 2 ; i < 11 ; i++) {
            for(int j = 2 ; j < i ; j++) {
                D[i][j] = D[i-1][j-1] + D[i-1][j];
            }
        }

        // for(int i = 0 ; i < 11 ; i++) {
        //   for(int j = 0 ; j < 11 ; j++) {
        //     System.out.print(D[i][j] + " ");
        //   }
        //   System.out.println();
        // }

        System.out.println(D[N][M]);

    }
}

