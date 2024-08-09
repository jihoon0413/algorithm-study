package org.example.백준.알고리즘기초_2.재귀.퇴사_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[2][N+1];

        StringTokenizer st;

        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            arr[0][i] = Integer.parseInt(st.nextToken());
            arr[1][i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 1);

        System.out.println(ans);

    }

    static void solve(int sum, int day) {

        if(day > N) {
            return;
        }

        for(int i = day ; i <=N ; i++) {
            if (i + arr[0][i] - 1 < N) {
                solve(sum+arr[1][i], i+arr[0][i]);
            } else if (i + arr[0][i]-1 == N) {
                ans = Math.max(ans, sum + arr[1][i]);
                solve(ans, i+arr[0][i]);
            }  else {
                ans = Math.max(ans, sum);
                solve(ans,i+arr[0][i]);
            }
        }
    }
}
