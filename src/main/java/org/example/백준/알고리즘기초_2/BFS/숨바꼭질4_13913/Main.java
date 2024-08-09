package org.example.백준.알고리즘기초_2.BFS.숨바꼭질4_13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] check =new int[100001];;
    static int[] seq =new int[100001];;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N!=K) {
            solve();
        } else {
            seq[N] = -1;
            check[K] = 0;
        }
        int idx = K;


        Stack<Integer> stack = new Stack<>();

        while(seq[idx] != -1) {
            stack.add(idx);
            idx = seq[idx];
        }

        sb.append(check[K]).append("\n");
        sb.append(N).append(" ");

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);

    }
    static void solve() {

        Queue<Integer> que = new LinkedList<>();
        que.offer(N);
        seq[N] = -1;
        check[N] = 1;

        while (!que.isEmpty()) {

            int loc = que.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if(i == 0) {
                    next = loc*2;
                } else if (i == 1) {
                    next = loc + 1;
                } else {
                    next = loc -1;
                }

                if(next == K) {
                    seq[next] = loc;
                    check[next] = check[loc];
                    return;
                }

                if (next >= 0 && next < 100001 && check[next] == 0) {
                    que.add(next);
                    seq[next] = loc;
                    check[next] = check[loc] + 1;
                }
            }
        }
    }
}

