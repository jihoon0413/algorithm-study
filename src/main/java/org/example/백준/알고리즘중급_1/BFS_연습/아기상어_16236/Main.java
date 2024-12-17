package org.example.백준.알고리즘중급_1.BFS_연습.아기상어_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] sea;
    static int[][] dist;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int sharkX;
    static int sharkY;
    static int sharkSize = 2;
    static int eat = 0;
    static int count = 0;
    static int minX, minY, minDist;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sea = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if(sea[i][j] == 9) {
                    sea[i][j] = 0;
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        while(true) {
            dist = new int[N+1][N+1];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;

            bfs(sharkX,sharkY);

            if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                eat++;
                sea[minX][minY] = 0;
                count += dist[minX][minY];
                sharkX = minX;
                sharkY = minY;

                if(eat == sharkSize) {
                    sharkSize++;
                    eat = 0;
                }
            } else {
                break;
            }
        }
        System.out.println(count);
    }

    static void bfs(int a, int b) {
        Queue<Shark> que = new LinkedList<>();
        que.add(new Shark(a,b));

        while (!que.isEmpty()) {

            Shark shark = que.poll();

            for (int j = 0; j < 4; j++) {
                int x = shark.x + dx[j];
                int y = shark.y + dy[j];

                if(x < 1 || x > N || y < 1 || y > N) {
                    continue;
                }

                if(sea[x][y] <= sharkSize && dist[x][y] == 0) {
                    dist[x][y] = dist[shark.x][shark.y]+1;

                    if(sea[x][y] > 0 && sea[x][y] < sharkSize) {
                        if(minDist > dist[x][y]) {
                            minDist = dist[x][y];
                            minX = x;
                            minY = y;
                        } else if(minDist == dist[x][y]) {
                            if(minX == x) {
                                if(minY > y) {
                                    minX = x;
                                    minY = y;
                                }
                            } else if(minX > x) {
                                minX = x;
                                minY = y;
                            }
                        }
                    }
                    que.add(new Shark(x,y));
                }
            }
        }
    }

    static boolean check(int size) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(sea[i][j] < size) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Shark {
        int x;
        int y;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}


