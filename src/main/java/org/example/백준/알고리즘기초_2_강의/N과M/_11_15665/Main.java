package org.example.백준.알고리즘기초_2_강의.N과M._11_15665;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        dfs(N, M, 0);
        System.out.println(sb);
    }

    static void dfs(int N, int M, int count) {

        if(count == M) {
            for(int i = 1 ; i <= M ;i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        int before = 0;
        for(int i = 1 ; i <= N ; i++) {
            if(!check[i] && before != arr[i]) {
                temp[count + 1] = arr[i];
                before = arr[i];
                dfs(N, M, count + 1);

            }
        }
    }
}
