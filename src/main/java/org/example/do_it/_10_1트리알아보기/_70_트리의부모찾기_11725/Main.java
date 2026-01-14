package org.example.do_it._10_1트리알아보기._70_트리의부모찾기_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());

        answer = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 1 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());


            list.get(s).add(e);
            list.get(e).add(s);
        }

        visited[1] = true;
        dfs(1);
        // Queue<Integer> que = new LinkedList<>();

        // que.add(1);
        // visited[1] = true;

        // while(!que.isEmpty()) {
        //   int parent = que.poll();

        //   for(int next : list.get(parent)) {
        //     if(!visited[next]) {
        //       visited[next] = true;
        //       que.add(next);
        //       answer[next] = parent;
        //     }
        //   }
        // }

        for(int i = 2 ; i <= N ; i++) {
            System.out.println(answer[i]);
        }
    }

    static void dfs(int a) {

        for(int next : list.get(a)) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
                answer[next] = a;
            }
        }

    }

}
