package org.example.do_it._6_1깊이우선탐색DFS._25_ABCDE_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static List<List<Integer>> list;
    static boolean[] check;
    static int N;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        check = new boolean[N];

        for(int i = 0 ; i < N ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 0 ; i < N ; i++) {
            dfs(i, 1);

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

    static void dfs(int a, int count) {
        if(count == 5) {
            flag = true;
            return;
        }

        check[a] = true;
        for(int node : list.get(a)) {
            if(!check[node]) {
                dfs(node, count + 1);
            }
        }
        check[a] = false;
    }

}