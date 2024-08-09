package org.example.백준.알고리즘기초_2.트리1.트리의높이와너비_2250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Integer>[] lists;
    static int[] minWidth;
    static int[] maxWidth;
    static int[] parent;
    static int index = 1;
    static int depths = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        minWidth = new int[N+1];
        maxWidth = new int[N+1];
        parent = new int[N+1];

        for(int i=0;i<=N;i++){
            minWidth[i] = Integer.MAX_VALUE;
            maxWidth[i] = Integer.MIN_VALUE;
            parent[i] = -1;
        }

        lists = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lists[a].add(b);
            lists[a].add(c);
            if(b!=-1) {
                parent[b] = a;
            }

            if(c!=-1) {
                parent[c] = a;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (parent[i] == -1) {
                solve(i, 1);
            }
        }

        int length = 0;
        int depth = 0;

        for (int i = 1; i <= depths; i++) {
            if(length < maxWidth[i]-minWidth[i]+1) {
                length = maxWidth[i] - minWidth[i] + 1;
                depth = i;
            }
        }

        System.out.println(depth + " " + length);

    }

    static void solve(int a,int depth) {

        depths= Math.max(depths, depth);

        if(lists[a].get(0) != -1) {
            solve(lists[a].get(0), depth + 1);
        }

        minWidth[depth] = Math.min(minWidth[depth], index);
        maxWidth[depth] = Math.max(maxWidth[depth], index++);

        if(lists[a].get(1) != -1) {
            solve(lists[a].get(1), depth + 1);
        }
    }
}
