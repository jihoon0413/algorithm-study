package org.example.백준.알고리즘중급_1.BFS_연습.적록색약_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] print;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        print = new char[N][N];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                print[i] = str.toCharArray();
            }
        }

        System.out.println(bfs());


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(print[i][j] == 'G') {
                    print[i][j] = 'R';
                }
            }
        }

        System.out.println(bfs());


    }

    static int bfs() {
        visit = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j]) {
                    count++;
                    check(i,j,print[i][j]);
                }
            }
        }
        return count;
    }

    static void check(int a, int b, char color) {

        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(a,b, color));
        visit[a][b] = true;

        while (!que.isEmpty()) {

            Node node = que.poll();

            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];

                if(x < 0 || x >= N || y < 0 || y >= N) {
                    continue;
                }

                if(!visit[x][y] && node.color == print[x][y]) {
                    que.offer(new Node(x,y,print[x][y]));
                    visit[x][y] = true;
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        char color;

        public Node(int x, int y, char color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

}
