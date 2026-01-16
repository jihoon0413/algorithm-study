package org.example.do_it._10_5최소공통조상._78_최소공통조상구하기2_11438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] depth;
    static boolean[] visited;
    static int[][] parent;
    static int kmax = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        int temp = 1;
        while(temp <= N) {
            temp *= 2;
            kmax++;
        }

        parent = new int[kmax+1][N+1];
        depth = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < N - 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1);

        for(int i = 1 ; i <= kmax ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
            }
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            find(a,b);
        }
    }

    static void find(int a, int b) {
        if(depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for(int i = kmax ; i >= 0 ; i--) {
            if(Math.pow(2,i) <= depth[b] - depth[a]) { //2^i만큼 점프해도 “깊이 차이를 초과하지 않는다” == a보다 얕아지지 않는다
                if(depth[a] <= depth[parent[i][b]]) {  // a 보다는 더 얕아지지 않도록
                    b = parent[i][b];
                }
            }
        }

        for(int i = kmax ; i >=0 ; i--) {
            if(parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        if(a != b) {
            a = parent[0][a];
            b = parent[0][b];
        }

        System.out.println(a);
    }

    static void bfs(int a) {
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{a,1});
        depth[a] = 1;
        visited[1] = true;

        while(!que.isEmpty()) {
            int[] info = que.poll();
            int now = info[0];
            int d = info[1];

            for(int next : list.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    parent[0][next] = now;
                    depth[next] = d+1;
                    que.add(new int[] {next, d+1});
                }
            }
        }
    }
}
