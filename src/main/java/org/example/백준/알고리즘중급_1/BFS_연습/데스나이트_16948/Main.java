package org.example.백준.알고리즘중급_1.BFS_연습.데스나이트_16948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] board;
    static int aimX;
    static int aimY;
    static int N;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        aimX = Integer.parseInt(st.nextToken());
        aimY = Integer.parseInt(st.nextToken());

        board[x][y] = true;
        solve(x,y);

        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);

    }
    static void solve(int r, int c) {

        Queue<int[]> que = new LinkedList<>();

        que.add(new int[] {r,c,0});


        while (!que.isEmpty()) {

            int[] temp = que.poll();

            int x = temp[0];
            int y = temp[1];
            int count = temp[2];


            if(x == aimX && y == aimY) {
                ans = Math.min(ans,count);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX < 0 || newX >= N || newY < 0 || newY >= N) {
                    continue;
                }

                if(!board[newX][newY]) {
                    board[newX][newY] = true;
                    que.offer(new int[] {newX,newY,count+1});
                }
            }

        }
    }
}
