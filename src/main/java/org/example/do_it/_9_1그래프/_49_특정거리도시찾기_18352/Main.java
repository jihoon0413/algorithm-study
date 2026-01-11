package org.example.do_it._9_1그래프._49_특정거리도시찾기_18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
        }
        visited = new boolean[N+1];

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
        }

        bfs(X, K);

        if(!flag) System.out.println(-1);
    }

    static void bfs(int node, int distance) {
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[] {node, 0});
        visited[node] = true;

        while(!que.isEmpty()) {
            int[] info = que.poll();
            int now = info[0];
            int dist = info[1];

            if(dist == distance) {
                flag = true;
                System.out.println(now);
            }
            Collections.sort(list.get(now));
            for(int next : list.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    que.add(new int[] {next, dist+1});
                }
            }
        }
    }
}
