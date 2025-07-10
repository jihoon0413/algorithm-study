package org.example.백준.삼성SW역량테스트.로봇청소기_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int count = 0, N, M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int way = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 1;
        clean(x,y,way);

        System.out.println(count);
    }


    static void clean(int x, int y, int way) {
        map[x][y] = 5;

        for (int i = 0; i < 4; i++) {
            way =(way+3)%4;

            int newX = x + dx[way];
            int newY = y + dy[way];

            if(map[newX][newY] == 0) {
                count++;
                clean(newX, newY, way);
                return;
            }
        }

        int back = (way+2)%4;
        int newX = x + dx[back];
        int newY = y + dy[back];

        if(map[newX][newY]!=1) {
            clean(newX, newY, way);
        }

    }

}