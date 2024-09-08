package org.example.백준.알고리즘중급_1.브루트포스_재귀_연습.알파벳_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int R,C;
    static boolean[] alpha = new boolean[26];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j)-'A';
            }
        }

        int index = arr[0][0];
        alpha[index] = true;
        solve(0,0, 1);
        alpha[index] = false;
        System.out.println(ans);

    }
    static void solve(int x, int y, int count) {

        if(count > ans) {
            ans = count;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newX >= R || newY < 0 || newY >= C) {
                continue;
            }

            int index = arr[newX][newY];
            if(!alpha[index]) {
                alpha[index] = true;
                solve(newX,newY,count+1);
                alpha[index] = false;
            }


        }


    }
}
