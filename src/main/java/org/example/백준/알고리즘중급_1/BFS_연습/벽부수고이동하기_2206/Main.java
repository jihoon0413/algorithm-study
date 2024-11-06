package org.example.백준.알고리즘중급_1.BFS_연습.벽부수고이동하기_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[][] map;
    static boolean[][][] check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N+1][M+1];
        check = new boolean[N+1][M+1][2];

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
        int ans = Integer.MAX_VALUE;

        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[] {1,1,0,1});

        while (!que.isEmpty()) {

            int[] temp = que.poll();
            int a = temp[0];
            int b = temp[1];
            int broken = temp[2];
            int count = temp[3];

            if(a == N && b == M) {
                ans = Math.min(ans,count);
            }

            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if(x < 1 || x > N || y < 1 || y > M) {
                    continue;
                }

                if(map[x][y] && broken == 0) {
                    check[x][y][1] = true;
                    que.offer(new int[] {x,y,1,count+1});
                } else if(!map[x][y]) {
                    if(broken == 0 && !check[x][y][0]) {
                        check[x][y][0] = true;
                        que.offer(new int[] {x,y,broken,count+1});
                    } else if(broken == 1 && !check[x][y][1]){
                        check[x][y][1] = true;
                        que.offer(new int[] {x,y,broken,count+1});
                    }
                }
            }
        }
        if(ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}
