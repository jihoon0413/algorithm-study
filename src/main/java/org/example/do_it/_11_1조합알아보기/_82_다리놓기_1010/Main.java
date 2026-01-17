package org.example.do_it._11_1조합알아보기._82_다리놓기_1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int T = Integer.parseInt(br.readLine());

        int[][] D = new int[30][30];

        for(int i = 0 ; i < 30 ; i++) {
            D[i][i] = 1;
            D[i][1] = i;
        }

        for(int i = 2 ; i < 30 ; i++) {
            for(int j = 2 ; j < i ; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }
        // for(int i = 1 ; i < 30 ; i++) {
        //   for(int j = 1 ; j < 30 ; j++) {
        //     System.out.print(D[i][j] + " ");

        //   }
        //     System.out.println();
        // }

        for(int i = 0 ; i < T ; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(D[M][N]);
        }

    }
}

