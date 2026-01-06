package org.example.do_it._6_2백트래킹._26_N과M_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static int N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];

        backTracking(0);
    }

    static void backTracking(int a) {
        if(list.size() == M) {
            for(int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1 ; i <= N ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);
                backTracking(i);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
