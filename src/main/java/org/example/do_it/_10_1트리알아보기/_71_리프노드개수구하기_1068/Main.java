package org.example.do_it._10_1트리알아보기._71_리프노드개수구하기_1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0, deleted;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        visited = new boolean[N];
        for(int i = 0 ; i < N ; i++) {
            list.add(new ArrayList<>());
        }

        int root = 0;
        for(int i = 0 ; i < N ; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1) {
                root = i;
                continue;
            }
            list.get(parent).add(i);
        }

        deleted = Integer.parseInt(br.readLine());
        list.get(deleted).clear();
        visited[root] = true;
        dfs(root);

        System.out.println(answer);

    }

    static void dfs(int a) {
        if(list.get(a).size() == 0 && a != deleted) {
            answer++;
            return;
        }

        for(int next : list.get(a)) {
            if(!visited[next] && next != deleted) {
                visited[next] = true;
                dfs(next);
                // visited[next] = false;
            } else if(next == deleted && list.get(a).size() == 1) {
                answer++;
            }
        }
    }
}

