package org.example.백준.알고리즘기초_2_강의.N과M._4_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] arr;
    static StringBuilder sb;
    static int[] temp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N+1];
        temp = new int[N+1];


        dfs(N,M, 0,1);

        System.out.println(sb);
    }
    static void dfs(int N, int M, int count, int start) {

        if(count == M) {
            for(int i = 1; i <= M ; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= N ; i++) {

                arr[i] = true;
                temp[count+1] = i;
                dfs(N,M,count+1, i);
                arr[i] = false;


        }

    }
}
