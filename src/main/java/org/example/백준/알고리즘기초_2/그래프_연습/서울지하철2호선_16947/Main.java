package org.example.백준.알고리즘기초_2.그래프_연습.서울지하철2호선_16947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] check;
    static List<Integer>[] list;
    static int N;
    static int temp;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        check = new boolean[N+1];
        visit = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N ; i++) {
            if(!check[i] && list[i].size() >= 2){
                check[i] = true;

                if(!checkCycle(i,i, 1)) {
                    check[i] = false;
                }
            }
        }

        for (int i = 1; i <= N ; i++) {
            if(check[i]) {
                sb.append(0).append(" ");
            } else {
                temp = N;
                visit[i] = true;
                solve(i, i, 0);
                visit[i] = false;
                sb.append(temp).append(" ");
            }
        }
        System.out.println(sb);


    }
    static boolean checkCycle(int start, int idx, int count) {

        if(list[idx].contains(start) && count > 2) {
            return true;
        }

        if(count >= N || list[idx].size() < 2) {
            return false;
        }

        for(int a : list[idx]) {
            if(!check[a]) {
                check[a] = true;
                if(!checkCycle(start, a, count +1)) {
                    check[a] = false;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    static void solve(int start, int i,int count) {

        if(check[i]) {
            temp = Math.min(temp,count);
            return;
        }

        for(int a : list[i]) {
            if(a != start && !visit[a]) {
                visit[i] = true;
                solve(start, a, count+1);
                visit[i] = false;
            }
        }
    }
}
