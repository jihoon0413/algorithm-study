package org.example.do_it._6_1깊이우선탐색DFS._23_연결요소의개수_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static List<List<Integer>> list;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];
        list = new ArrayList<>();

        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 1 ; i <= N ; i++) {
            if(!check[i]) {
                dfs(i);
                answer++;
            }

        }
        System.out.println(answer);

    }

    public static void dfs(int idx) {
        if(check[idx]) {
            return;
        }

        check[idx] = true;
        for(int node : list.get(idx)) {
            if(!check[node]) dfs(node);
        }
    }
}

