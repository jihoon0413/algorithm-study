package org.example.백준.삼성SW역량테스트.뱀_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N;
    static int[][] map;
    static Map<Integer, Character> directionInfo = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        M = Integer.parseInt(br.readLine());


        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int second = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            directionInfo.put(second,dir);
        }


        Queue<Integer> que = new LinkedList<>();
        que.add(N+1);
        int x = 1;
        int y = 1;
        int time = 0;
        int dir = 0;

        while(true) {

            int newX = x + dx[dir];
            int newY = y + dy[dir];
            time++;

            if(newX <= 0 || newX > N || newY <= 0 || newY > N) {
                break;
            }

            if(que.contains(newX*N + newY)) {
                break;
            }


            if(map[newX][newY] == 1) {
                que.add(newX*N + newY);
                map[newX][newY] = 0;
            } else {
                que.add(newX*N + newY);
                que.poll();
            }


            if (directionInfo.containsKey(time)) {
                char direction = directionInfo.get(time);
                if (direction == 'D') {
                    dir++;
                    dir%=4;
                } else {
                    dir--;
                    if(dir ==-1) dir=3;
                }
            }
            x = newX;
            y = newY;
        }

        System.out.println(time);
    }
}