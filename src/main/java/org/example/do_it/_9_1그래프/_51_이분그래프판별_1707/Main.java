package org.example.do_it._9_1그래프._51_이분그래프판별_1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static List<List<Integer>> list;
    static int[] arr;
    static boolean flag;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int K = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            arr = new int[V+1];
            visited = new boolean[V+1];
            flag = true;
            for(int j = 0 ; j <= V ; j++) {
                list.add(new ArrayList<>());
            }

            for(int k = 0 ; k < E ; k++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }

            for(int j = 1 ; j <= V ; j++) {
                bfs(j);
            }
            // dfs(1, 1);
            // for(int j = 2 ; j <= V; j++) {
            //   if(!flag) break;
            //   if(arr[j] == 0) {
            //     arr = new int[V+1];
            //     dfs(j, 1);
            //   }
            // }

            for(int j = 1; j <= V ;j++) {
                bfs(j);
            }

            if(flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void bfs(int a) {
        Queue<Integer> que = new LinkedList<>();

        que.add(a);
        visited[a] = true;

        while(!que.isEmpty()) {
            int now = que.poll();

            for(int next : list.get(now)) {
                if(!visited[next]) {
                    arr[next] = (arr[now] + 1) % 2;
                    visited[next] = true;
                    que.add(next);
                } else if(arr[now] == arr[next]) {
                    flag = false;
                    return;
                }
            }
        }

    }

    static void dfs(int now, int color) {

        arr[now] = color;

        for(int next : list.get(now)) {
            if(arr[next] == 0) {
                dfs(next, color*-1);
            } else if(arr[next] == color) {
                flag = false;
                return;
            }
        }
    }

}