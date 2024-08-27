package org.example.백준.알고리즘중급_1.브루트포스_재귀_연습.N_Queen_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[][] boardVisit;
    static boolean[][] board;
    static boolean[] visitY;
    static int ans = 0;
    static int[] dx = {1,1,1,-1,-1,-1,0,0};
    static int[] dy = {0,1,-1,0,1,-1,1,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        boardVisit = new boolean[N][N];
        board = new boolean[N][N];
        visitY = new boolean[N];

        for (int i = 0; i < N; i++) {
            visit(0,i);
            solve(0,i,1);
            unVisit(0,i);
        }

        System.out.println(ans);

    }
    static void solve(int x, int y, int count) {

        if(count == N) {
            ans++;
            return;
        }

        int temp = x+1;
        for (int j = 0; j < N; j++) {
            if (!boardVisit[temp][j] && !visitY[j]) {
                if(check(temp,j)) {
                    visit(temp, j);
                    solve(temp, j, count + 1);
                    unVisit(temp, j);
                }

            }
        }

    }

    static boolean check(int x, int y) {

        boolean flag = true;

        for (int i = 0; i < 8; i++) {
            int newX = x;
            int newY = y;

            while (true) {
                newX += dx[i];
                newY += dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= N) {
                    break;
                }

                if(board[newX][newY]) {
                    flag = false;
                }

            }
        }
        return flag;
    }


    static void visit(int x, int y) {
        boardVisit[x][y] = true;
        board[x][y] = true;
        visitY[y] = true;

        for (int i = 0; i < 3; i++) {
            int newX = x;
            int newY = y;

            while (true) {
                newX += dx[i];
                newY += dy[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= N) {
                    break;
                }

                if (!boardVisit[newX][newY]) {
                    boardVisit[newX][newY] = true;
                }
            }
        }

    }

    static void unVisit(int x, int y) {
        boardVisit[x][y] = false;
        board[x][y] = false;
        visitY[y] = false;

        for (int i = 0; i < 3; i++) {
            int newX = x;
            int newY = y;

            while (true) {
                newX += dx[i];
                newY += dy[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= N) {
                    break;
                }

                if (boardVisit[newX][newY]) {
                    boardVisit[newX][newY] = false;
                }
            }
        }
    }
}
