package org.example.백준.알고리즘기초_2_강의.트리1.트리의부모찾기_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static List<Integer>[] lists;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];


        lists = new ArrayList[N+1];
        check = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
            parent[i] = N+1;
        }

        StringTokenizer st;

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lists[a].add(b);
            lists[b].add(a);
        }

        solve(1);


        for (int i = 2; i <= N ; i++) {
            System.out.println(parent[i]);
        }

    }
    static void solve(int a) {

        for(int temp : lists[a]) {
            if(!check[temp]) {
                check[temp] = true;
                parent[temp] = a;
                solve(temp);
                check[temp] = false;
            }
        }

    }
}
