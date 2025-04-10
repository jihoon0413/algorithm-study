package org.example.백준.알고리즘중급_1.분할정복_연습.별찍기10_2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static char[][] arr;
    static List<Integer> num = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N+1][N+1];
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = ' ';
            }
        }


        findBlank(1, 1, N);
        Collections.sort(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N ; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void findBlank(int s, int e, int size) {

        if(size == 1) {
            arr[s][e] = '*';
            return;
        }

        int newSize = size/3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) {
                    continue;
                }
                int tempX = s + (newSize*i);
                int tempY = e + (newSize*j);

                findBlank(tempX,tempY,newSize);
            }
        }
    }
}
