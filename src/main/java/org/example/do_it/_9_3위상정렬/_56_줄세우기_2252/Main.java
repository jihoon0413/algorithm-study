package org.example.do_it._9_3위상정렬._56_줄세우기_2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[N+1];

        for(int i = 0 ; i  <= N ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i = 1 ; i <= N ; i++) {
            if(indegree[i] == 0) {
                que.add(i);
            }
        }

        while(!que.isEmpty()) {
            int now = que.poll();
            System.out.print(now + " ");
            for(int next : list.get(now)) {
                indegree[next]--;
                if(indegree[next] == 0) que.add(next);
            }
        }

        // while(true) {
        //   boolean flag = true;
        //   for(int i = 1; i <= N ; i++) {
        //     if(indegree[i] == 0) {
        //       flag = false;
        //       for(int a : list.get(i)) {
        //         indegree[a]--;
        //       }
        //       indegree[i]--;
        //       System.out.print(i + " ");
        //     }
        //   }
        //   if(flag) break;
        // }


    }
}

