package org.example.do_it._9_3위상정렬._57_게임개발하기_1516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N+1];
        int[] indegree = new int[N+1];
        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            time[i] = temp;
            while(true) {
                temp = Integer.parseInt(st.nextToken());
                if(temp == -1) break;
                list.get(temp).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        int[] result = new int[N+1];

        for(int i = 1 ; i <= N ; i++) {
            if(indegree[i] == 0) {
                que.add(i);
                result[i] = time[i];
            }
        }

        while(!que.isEmpty()) {
            int now = que.poll();

            for(int next : list.get(now)) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + time[next]);
                if(indegree[next] == 0) que.add(next);
            }
        }

        for(int i = 1; i <= N ; i++) {
            System.out.println(result[i]);
        }
    }
}

