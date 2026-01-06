package org.example.do_it._6_2백트래킹._28_색종이붙이기_17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] M;
    static int[] paperCount = new int[6];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = new int[10][10];

        for(int i = 0 ; i < 10 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 10 ; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        backtracking(0, 0);


        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
    static void backtracking(int xy, int useCnt) {
        if(xy == 100) {
            answer = Math.min(answer, useCnt);
            return;
        }

        int x = xy/10;
        int y = xy%10;

        if(answer <= useCnt) {
            return;
        }
        if(M[x][y] == 1) {
            for(int i = 5 ; i >= 1; i--) {
                if(paperCount[i] < 5 && checkSize(x,y,i)) {
                    fill(x,y,i,0);
                    paperCount[i]++;
                    backtracking(xy+1, useCnt+1);
                    fill(x,y,i,1);
                    paperCount[i]--;
                }
            }
        } else {
            backtracking(xy+1, useCnt);
        }

    }

    static boolean checkSize(int x, int y, int size) {
        if( x + size > 10 || y + size > 10) {
            return false;
        }
        for(int i = x ; i < x + size ; i++) {
            for(int j = y ; j < y + size ; j++) {
                if(M[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void fill(int x, int y, int size, int value) {
        for(int i = x ; i < x + size ; i++) {
            for(int j = y ; j < y + size ; j++) {
                M[i][j] = value;
            }
        }
    }
}

