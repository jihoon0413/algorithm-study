package org.example.백준.알고리즘기초_2_강의.BFS.숨바꼭질3_13549;

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
            int time = check[loc];

            for (int i = 0; i < 3; i++) {
                int newLoc;
                int newTime;

                if(i == 0) {
                    newLoc = loc*2;
                    newTime = time;
                } else if (i == 1) {
                    newLoc = loc + 1;
                    newTime = time + 1;
                } else {
                    newLoc = loc -1;
                    newTime = time + 1;
                }

                if(newLoc == K) {
                    ans = Math.min(ans, newTime-1);
                    continue;
                }

                if (newLoc >= 0 && newLoc < 100001) {
                    if(check[newLoc] == 0 || check[newLoc] > newTime){
                        check[newLoc] = newTime;
                        que.add(newLoc);
                    }
                }
            }
        }
    }
}