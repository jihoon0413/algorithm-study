package org.example.백준.알고리즘중급_1.분할정복_연습.별찍기11_2448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char [][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N+1][2*N+1];

        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N*2 ; j++) {
                arr[i][j] = ' ';
            }
        }

        findSection(1,N,N);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N*2 ; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
    static void findSection(int x, int y, int size) {

        if(size == 3) {

            arr[x][y] = '*';
            arr[x+1][y-1] = '*';
            arr[x+1][y+1] = '*';
            for (int i = 0; i < 5; i++) {
                arr[x+2][y-2+i] ='*';
            }
            return;
        }


        int newSize = size/2;

        findSection(x,y,newSize);
        findSection(x+newSize, y-newSize, newSize);
        findSection(x+newSize, y+newSize, newSize);


    }
}
