package org.example.do_it._11_1조합알아보기._81_부녀회장_2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] D = new int[15][15];

        for(int i = 0 ; i < 15 ; i++) {
            D[0][i]= i;
        }

        for(int i = 1 ; i < 15 ; i++) {
            for(int j = 1 ; j < 15 ; j++) {
                D[i][j] = D[i][j-1] + D[i-1][j];
            }
        }

        for(int k = 0 ; k < N ; k++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            System.out.println(D[a][b]);
        }
    }
}
