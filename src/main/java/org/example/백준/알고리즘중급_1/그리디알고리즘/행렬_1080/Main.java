package org.example.백준.알고리즘중급_1.그리디알고리즘.행렬_1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arrA;
    static int[][] arrB;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrA = new int[N][M];
        arrB = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == '0') {
                    arrA[i][j] = 0;
                } else {
                    arrA[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == '0') {
                    arrB[i][j] = 0;
                } else {
                    arrB[i][j] = 1;
                }
            }
        }

        if(N < 3 || M < 3) {
            if(isSameArr()) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
            return;
        }

        int ans = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < M-2; j++) {
                if(arrA[i][j] != arrB[i][j]) {
                    changeSquareBoard(i,j);
                    ans++;
                }
            }
        }

        if (!isSameArr()) {
            ans = -1;
        }

        System.out.println(ans);

    }

    public static void changeSquareBoard(int x, int y) {
        for (int i = x; i < x+3; i++) {
            for (int j = y; j < y+3; j++) {
                arrA[i][j] = arrA[i][j]==0?1:0;
            }
        }
    }

    public static boolean isSameArr() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arrA[i][j] != arrB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
