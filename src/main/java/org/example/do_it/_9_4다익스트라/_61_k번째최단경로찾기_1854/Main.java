package org.example.do_it._9_4다익스트라._61_k번째최단경로찾기_1854;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> list = new ArrayList<>();
    static List<PriorityQueue<Integer>> result = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
            result.add(new PriorityQueue<>(K, (o1,o2) -> {
                return o2 - o1;
            }));
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b,c));
        }

        PriorityQueue<Node> que = new PriorityQueue<>((o1,o2) -> {
            return o1.time - o2.time;
        });

        que.add(new Node(1,0));
        result.get(1).add(0);


        while(!que.isEmpty()) {
            Node now = que.poll();

            for(Node next : list.get(now.vertex)) {

                if(result.get(next.vertex).size() < K) {
                    result.get(next.vertex).add(now.time + next.time);
                    que.add(new Node(next.vertex, now.time+ next.time));
                } else if(result.get(next.vertex).peek() > now.time + next.time) {
                    result.get(next.vertex).poll();
                    result.get(next.vertex).add(now.time + next.time);
                    que.add(new Node(next.vertex, now.time+ next.time));
                }
            }
        }

        for(int i = 1; i <= N ; i++) {
            PriorityQueue<Integer> temp = result.get(i);
            if(temp.size() != K) {
                System.out.println(-1);
            } else {
                System.out.println(temp.peek());
            }
        }

    }

    static class Node {
        int vertex;
        int time;

        public Node(int vertex, int time) {
            this.vertex = vertex;
            this.time = time;
        }
    }
}

