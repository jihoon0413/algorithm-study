package org.example.백준.알고리즘기초_2_강의.그래프_연습.twodots_16929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] arr;
    static boolean[][] check;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = (char) (str.charAt(j)-'A');
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                solve(i,j, arr[i][j], i,j);
                if(flag) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }
    static void solve(int a, int b, char color, int oldA, int oldB) {

        int newX = 0;
        int newY = 0;
        for (int i = 0; i < 4; i++) {
            newX = a + dx[i];
            newY = b + dy[i];

            if(newX < 0 || newX >= N || newY < 0 || newY >= M) {
                continue;
            }

            if(!(newX == oldA && newY == oldB) && !check[newX][newY] && arr[newX][newY] == color ) {
                check[a][b] = true;
                solve(newX,newY,color,a,b);
                check[a][b] = false;
            }

            if(!(newX == oldA && newY == oldB) && check[newX][newY] && arr[newX][newY] == color ) {
               flag = true;
            }
        }
        
    }
}
