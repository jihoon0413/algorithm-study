package org.example.백준.알고리즘기초_2_강의.그래프.이분그래프_1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] check;
    static int V;
    static int E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        for(int testCase = 0 ; testCase < k ; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            check = new int[V+1];

            for (int i = 1 ; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }
            solve();
        }
    }

    static void solve() {
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <= V; i++) {
            if (check[i] == 0) {
                que.add(i);
                check[i] = 1;
            }

            int val;

            while (!que.isEmpty()) {
                val = que.poll();

                for(int j : graph[val]) {
                    if(check[j] == 0) {
                        que.offer(j);
                        if(check[val] == 1) {
                            check[j] = 2;
                        } else if (check[val] == 2) {
                            check[j] = 1;
                        }
                    }

                    if(check[j] == check[val]) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        System.out.println("YES");
    }
}
