package org.example.do_it._9_1그래프._50_효율적인해킹_1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] ansList;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
        }

        visited = new boolean[N + 1];

        ansList = new int[N+1];
        for(int i = 1 ; i <= N ; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }
        int maxValue = 0;
        for(int i = 1; i <= N ; i++) {
            maxValue = Math.max(maxValue, ansList[i]);
        }

        for(int i = 1 ; i <= N ;i++) {
            if(ansList[i] != maxValue) continue;
            System.out.print(i + " ");
        }

    }

    static void dfs(int a) {

        visited[a] = true;
        for(int next : list.get(a)) {
            if(!visited[next]) {
                ansList[next]++;
                dfs(next);
            }
        }
    }
}
