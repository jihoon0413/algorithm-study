package org.example.백준._2차원배열.색종이_2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] a = new boolean[101][101];
        int count = Integer.parseInt(br.readLine());
        int area = 0;


        for(int i = 0 ; i < count ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = x ; j < x + 10 ; j++) {
                for(int k = y ; k < y + 10 ; k++) {
                    if(!a[k][j]) {
                        a[k][j] = true;
                        area++;
                    }
                }
            }
        }


        System.out.print(area);
    }
}
