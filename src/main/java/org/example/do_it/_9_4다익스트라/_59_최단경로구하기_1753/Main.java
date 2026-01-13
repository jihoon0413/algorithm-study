package org.example.do_it._9_4다익스트라._59_최단경로구하기_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> que;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int S = Integer.parseInt(br.readLine());

        result = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
            result[i] = Integer.MAX_VALUE;
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, v));
        }

        que = new PriorityQueue<>((o1,o2) -> {
            return o1.value - o2.value;
        });

        result[S] = 0;
        que.add(new Node(S,0));

        while(!que.isEmpty()) {
            Node now = que.poll();

            if(visited[now.node]) continue;  // 아래서 최소 값이 업데이트 해주기 때문에 true는 굳이 다시 안해도 됨
            visited[now.node] = true;

            for(Node next : list.get(now.node)) {
                if(result[next.node] > result[now.node] + next.value) {
                    result[next.node] = result[now.node] + next.value;
                    que.add(new Node(next.node, result[next.node]));     // 새로운 최단 거리가 생겼을 때만 que가 추가!!!! 안그럼 메모리 초과
                }
            }
        }

        for(int i = 1 ; i <= N ; i++) {
            if(visited[i]) {
                System.out.println(result[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    static class Node {
        int node;
        int value;

        public Node(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}

