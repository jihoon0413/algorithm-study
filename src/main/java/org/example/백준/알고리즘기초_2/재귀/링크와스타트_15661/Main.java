package org.example.백준.알고리즘기초_2.재귀.링크와스타트_15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] check;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        check = new boolean[N+1];

        StringTokenizer st;

        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(1,0);
        System.out.println(ans);

    }
    static void solve(int index, int count) {

        if(count < N) {
            int start = 0;
            int link = 0;
            for(int i = 1; i <= N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    if(check[i] && check[j]) {
                        start += arr[i][j];
                    }
                    if(!check[i] && !check[j]) {
                        link += arr[i][j];
                    }
                }
            }
            ans = Math.min(ans, Math.abs(start-link));
        } else {
            return;
        }


        for(int i = index ; i <= N ; i++) {
            if(!check[i]) {
                check[i] = true;
                solve(i+1, count+1);
                check[i] = false;

            }
        }

    }
}
