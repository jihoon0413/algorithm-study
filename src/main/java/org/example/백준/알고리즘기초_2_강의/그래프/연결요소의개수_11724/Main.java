package org.example.백준.알고리즘기초_2_강의.그래프.연결요소의개수_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] list;
    static boolean[] check;
    static int ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        check = new boolean[N+1];

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            if(!check[i]) {
                if(N == solve2(i)) {
                    ans++;
                    break;
                } else {
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }

    static int solve2(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        check[start] = true;
        int count = 1;
        int val;

        while (!que.isEmpty()) {

            val = que.poll();
            for(int i : list[val]) {
                if(!check[i]) {
                    check[i] = true;
                    que.add(i);
                    count++;
                }
            }

        }

        return count;


    }
}
