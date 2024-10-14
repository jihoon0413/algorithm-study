package org.example.백준.알고리즘중급_1.BFS_연습.연구소_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    static int M;
    static int ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);

        System.out.println(ans);

    }
    static void dfs(int wallCount) {
        if(wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCount+1);
                    map[i][j] = 0;
                }
            }
        }


    }

    static void bfs() {
        Queue<Node> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2) {
                    que.add(new Node(i,j));
                }
            }
        }

        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!que.isEmpty()) {
            Node tempNode = que.poll();
            int nowX = tempNode.x;
            int nowY = tempNode.y;

            for (int i = 0; i < 4; i++) {

                int x = nowX + dx[i];
                int y = nowY + dy[i];

                if(x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                }

                if(copyMap[x][y] == 0) {
                    copyMap[x][y] = 2;
                    que.offer(new Node(x,y));
                }
            }
        }
        countSafeZone(copyMap);
    }

    static void countSafeZone(int[][] copyMap) {
        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copyMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }
        ans = Math.max(ans, safeZone);
    }

    static class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
