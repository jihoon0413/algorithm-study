package org.example.do_it._8_3유클리드호제법._47_칵테일만들기_1033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> list;
    static long lcm = 1;
    static boolean[] visited;
    static long[] D;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[N];
        D = new long[N];

        for(int i  = 0 ; i < N ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0 ; i < N -1  ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, p, q));
            list.get(b).add(new Node(a, q, p));
            lcm *= ((p*q)/ gcd(p,q));
        }

        D[0] = lcm;
        dfs(0);
        long mgcd = D[0];
        for(int i = 1 ; i < N ; i++) {
            mgcd = gcd(mgcd, D[i]);
        }

        for(int i = 0 ; i < N ; i++) {
            System.out.print(D[i]/mgcd + " ");
        }

    }

    static void dfs(int a) {
        visited[a] = true;
        for(Node node : list.get(a)) {
            int next = node.b;
            if(!visited[next]) {
                D[next] = D[a] * node.q /node.p;

                dfs(next);
            }
        }
    }

    static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }

    static class Node {
        int b;
        int p;
        int q;

        public Node(int b, int p, int q) {
            this.b = b;
            this.p = p;
            this.q = q;
        }
    }

}