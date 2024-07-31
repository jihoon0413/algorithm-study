package org.example.백준.알고리즘기초_2_강의.BFS.숨바꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] check;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new int[100001];

        if(N!=K) {
            solve();
        } else {
            ans = 0;
        }
        System.out.println(ans);

    }
    static void solve() {

        Queue<Integer> que = new LinkedList<>();
        que.offer(N);
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
                    ans = Math.min(ans, check[loc]);
                    return;
                }

                if (next >= 0 && next < 100001 && check[next] == 0) {
                    que.add(next);
                    check[next] = check[loc] + 1;
                }
            }
        }
    }
}
