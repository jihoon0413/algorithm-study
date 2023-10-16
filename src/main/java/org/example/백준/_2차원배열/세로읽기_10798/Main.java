package org.example.백준._2차원배열.세로읽기_10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] a = new char[5][15];
        int max = 0;

        for(int i =0 ; i < 5 ; i++) {
           String str = br.readLine();
            if(max < str.length()) max = str.length();

            for(int j = 0 ; j < str.length(); j++) {
                a[i][j] = str.charAt(j);
            }
        }

        for(int i =0 ; i < max ; i++) {
            for(int j = 0 ; j < a.length; j++) {
                if(a[j][i] == '\0') { 	// char 배열의 초깃값 = '\0'
                    continue;
                }
                System.out.print(a[j][i]);
            }
        }
    }
}
