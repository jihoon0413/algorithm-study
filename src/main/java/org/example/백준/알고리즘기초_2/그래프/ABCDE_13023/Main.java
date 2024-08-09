package org.example.백준.알고리즘기초_2.그래프.ABCDE_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static ArrayList<Integer>[] list;
    static boolean[] check;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N];
        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            check[i] = true;
            solve(i,1);
            check[i] = false;
            if(flag) {
                break;
            }
        }

        if(flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }
    static void solve(int start, int count) {

        if(count == 5) {
            flag = true;
            return;
        }

        for (int i : list[start]) {
            if(!check[i]) {
                check[i] = true;
                solve(i, count+1);
                check[i] = false;
            }
        }

    }
}
