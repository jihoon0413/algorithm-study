package org.example.백준.알고리즘중급_1.BFS_연습.벽부수고이동하기3_16933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;
    static boolean[][] map;
    static boolean[][][] check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][M+1];
        check = new boolean[N+1][M+1][K+1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == '0') {
                    map[i][j+1] = false;
                } else {
                    map[i][j+1] = true;
                }
            }
        }
        check[1][1][0] = true;
        System.out.println(solve());

    }
    static int solve() {

        Queue<Loc> que = new LinkedList<>();
        que.offer(new Loc(1,1,0,1,true));
        int ans = Integer.MAX_VALUE;

        while (!que.isEmpty()) {

            Loc temp = que.poll();

            if(temp.x == N && temp.y == M) {
                ans = Math.min(ans, temp.count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int x = temp.x + dx[i];
                int y = temp.y + dy[i];
                int breakCount = temp.breakCount;
                int count = temp.count;
                boolean time = temp.time;

                if(x <= 0 || x > N || y <= 0 || y > M) {
                    continue;
                }


                if(!map[x][y] && !check[x][y][breakCount]) {
                    check[x][y][breakCount] = true;
                    que.offer(new Loc(x, y, breakCount, count + 1, !time));
                } else if(map[x][y] && breakCount < K && !check[x][y][breakCount]) {
                    if (time) {
                        check[x][y][breakCount] = true;
                        que.offer(new Loc(x, y, breakCount + 1, count + 1, false));
                    } else {
                        que.offer(new Loc(temp.x, temp.y, breakCount, count + 1, true));
                    }
                }


            }
        }
        if(ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    public static class Loc {
        int x;
        int y;
        int breakCount;
        int count;
        boolean time;

        public Loc(int x, int y , int breakCount, int count, boolean time) {
            this.x = x;
            this.y = y;
            this.breakCount = breakCount;
            this.count = count;
            this.time = time;
        }
    }
}

