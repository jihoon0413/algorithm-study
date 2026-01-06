package org.example.do_it._6_3너비우선탐색._30_미로탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static boolean[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                if(str.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }
        }

        bfs(N-1,M-1);

    }

    static void bfs(int x, int y) {
        Queue<Loc> que = new LinkedList<>();
        int answer = 0;

        que.add(new Loc(0,0,1));
        map[0][0] = false;

        while(!que.isEmpty()) {
            Loc loc = que.poll();

            if(loc.x == x && loc.y == y) {
                System.out.println(loc.count);
                break;
            }
            int X = loc.x;
            int Y = loc.y;

            for(int i = 0 ; i < 4 ; i++) {
                int newX = X + dx[i];
                int newY = Y + dy[i];

                if(newX < 0 || newX > x || newY < 0 || newY > y) {
                    continue;
                }

                if(map[newX][newY]) {
                    map[newX][newY] = false;
                    que.add(new Loc(newX, newY, loc.count+1));
                }

            }
        }
    }

    public static class Loc {
        int x;
        int y;
        int count;

        public Loc(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
