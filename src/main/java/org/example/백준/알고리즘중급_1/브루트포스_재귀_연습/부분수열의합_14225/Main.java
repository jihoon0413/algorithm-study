package org.example.백준.알고리즘중급_1.브루트포스_재귀_연습.부분수열의합_14225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] sum;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        sum = new boolean[2500000];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);

        int idx = 0;
        while (sum[idx]) {
            idx++;
        }

        System.out.println(idx);

    }
    static void solve(int a, int idx) {
        if(idx == N) {
            sum[a] = true;
            return;
        }

        sum[a] = true;

        solve(a+arr[idx], idx+1);
        solve(a, idx+1);

    }
}
