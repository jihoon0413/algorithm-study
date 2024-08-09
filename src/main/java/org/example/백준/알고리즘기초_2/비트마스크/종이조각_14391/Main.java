package org.example.백준.알고리즘기초_2.비트마스크.종이조각_14391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] check;
    static int N;
    static int M;
    static int ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        check = new boolean[N+1][M+1];

        for(int i = 1 ; i <= N ; i++) {
            String temp = br.readLine();
            for(int j = 1; j <= M ; j++) {
                arr[i][j] = temp.charAt(j-1)-48;
            }
        }

        solve(1,1);

        System.out.println(ans);

    }
    static void solve(int x, int y) {
        if(x == N+1) {
            sum();
            return;
        }
        if(y == M+1) {
            solve(x+1, 1);
            return;
        }

        check[x][y] = true;
        solve(x,y+1);

        check[x][y] = false;
        solve(x,y+1);
    }

    static void sum() {
        int result = 0;
        int temp;

        for(int i = 1 ; i <= N ; i++) {
            temp = 0;
            for(int j = 1 ; j <= M ; j++) {
                if(check[i][j]) {
                    temp = temp*10 + arr[i][j];
                } else {
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;
        }


        for(int i = 1 ; i <= M ; i++) {
            temp = 0;
            for(int j = 1 ; j <= N ; j++) {
                if(!check[j][i]) {
                    temp = temp * 10 + arr[j][i];
                } else {
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;
        }

        ans = Math.max(ans, result);

    }

}
