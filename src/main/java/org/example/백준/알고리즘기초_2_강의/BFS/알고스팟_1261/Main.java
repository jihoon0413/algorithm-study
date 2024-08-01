package org.example.백준.알고리즘기초_2_강의.BFS.알고스팟_1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] count;
    static int M;
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        count = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        if(N != 1 || M != 1) {
            solve();
        } else {
            ans = 0;
        }
        System.out.println(ans);

    }
    static void solve() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {1,1,1});
        count[1][1] = 1;
        //x, y, 벽을 부순 횟수

        while (!que.isEmpty()) {

            int[] temp = que.poll();
            int a = temp[0];
            int b = temp[1];
            int c = temp[2];

            if(a == N && b == M) {
                ans = Math.min(ans, c-1);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];

                if(x < 1 || x  > N || y < 1 || y > M) {
                    continue;
                }

                if(arr[x][y] == 1) {
                    if(count[x][y] == 0 || count[x][y] > c+1) {
                        count[x][y] = c+1;
                        que.offer(new int[] {x, y, c+1});
                    }
                } else {
                    if(count[x][y] == 0 || count[x][y] > c) {
                        count[x][y] = c;
                        que.offer(new int[] {x, y, c});
                    }
                }
            }
        }
    }
}
