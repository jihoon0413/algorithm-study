package org.example.백준.알고리즘기초_2.그래프1_도전.DFS스페셜저지_16964;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer>[] list;
    static int[] seq;
    static int [] parent;
    static boolean[] check;
    static boolean flag = false;
    static int index = 1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        seq = new int[N + 1];
        parent = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        if(seq[1] != 1) {
            System.out.println(0);
            return;
        }

        solve(1);

        if(flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }
    static void solve(int node) {

        if(index == N) {
            flag = true;
            return;
        }

        int size = 0;

        for(int a : list[node]) {
            if(!check[a]) {
                parent[a] = node;
                size++;
            }
        }

        check[node] = true;

        for (int i = 0; i < size; i++) {
            if(index+1 <= N) {

                if(!check[seq[index+1]] && node == parent[seq[index+1]]) {
                    index++;
                    solve(seq[index]);
                }
            } else {
                return;
            }
        }

    }
}
