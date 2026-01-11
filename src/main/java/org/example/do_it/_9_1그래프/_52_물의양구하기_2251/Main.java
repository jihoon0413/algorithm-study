package org.example.do_it._9_1그래프._52_물의양구하기_2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
import java.util.*;

public class Main {
    static int[] now;
    static int[] sender = {0,0,1,1,2,2};
    static int[] receiver = {1,2,0,2,0,1};
    static boolean[] answer = new boolean[201];
    static boolean[][] visited = new boolean[201][201];
    static Set<Integer> ansSet = new HashSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        now = new int[] {A,B,C};

        bfs();

        for(int i = 0 ; i < answer.length ; i++) {
            if(answer[i]) System.out.print(i + " ");
        }

    }

    static void bfs() {
        Queue<AB> que = new LinkedList<>();
        que.add(new AB(0,0));

        answer[now[2]] = true;

        while(!que.isEmpty()) {
            AB q = que.poll();
            int a = q.A;
            int b = q.B;
            int c = now[2] - a - b;

            for(int i = 0 ; i < 6 ; i++) {
                int[] next = {a, b, c};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;

                if (next[receiver[i]] > now[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - now[receiver[i]]; // 넘친거 이전 물통에 채워줌
                    next[receiver[i]] = now[receiver[i]]; // 최대로 채워줌
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    que.add(new AB(next[0], next[1]));
                    if (next[0] == 0)
                        answer[next[2]] = true;
                }
            }
        }
    }

    static class AB {
        int A;
        int B;
        public AB(int a, int b) {
            this.A = a;
            this.B = b;
        }
    }
}

