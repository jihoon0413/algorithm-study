package org.example.백준.알고리즘기초_2.N과M._6_15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static int[] arr;
    static int[] temp;
    static boolean[] check;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        check = new boolean[N+1];
        temp = new int[M+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(N, M, 0, 1);
    }

    static void dfs(int N, int M, int count, int start) {

        if(count == M) {
            for(int i = 1 ; i <= M ;i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }



        for(int i = start ; i <= N ; i++) {
            if(!check[i]) {

                temp[count + 1] = arr[i];
                check[i] = true;
                dfs(N, M, count + 1, i+1);
                check[i] = false;

            }
        }
    }
}
