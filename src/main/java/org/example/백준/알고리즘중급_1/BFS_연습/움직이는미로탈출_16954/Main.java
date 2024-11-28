package org.example.백준.알고리즘중급_1.BFS_연습.움직이는미로탈출_16954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] board = new int[9][9];
    static int[] dx = {0, -1, 0, 1, 0, 1, -1, -1, 1};
    static int[] dy = {-1, 0, 1, 0, 0, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 8; i++) {
            String str = br.readLine();
            for (int j = 1; j <= 8; j++) {
                if(str.charAt(j-1) == '#') {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }

        if(solve()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean solve() {
        Queue<Loc> que = new LinkedList<>();
        boolean[][] visit;

        que.add(new Loc(8,1,0));

        while (!que.isEmpty()) {

            int size = que.size();

            visit = new boolean[9][9];


            for (int i = 0; i < size; i++) {

                Loc temp = que.poll();

                if(board[temp.x][temp.y] == 1) {
                    continue;
                }

                if(temp.x == 1 && temp.y == 8) {
                    return true;
                }

                for (int j = 0; j < 9; j++) {
                    int x = temp.x + dx[j];
                    int y = temp.y + dy[j];

                    if(x <= 0 || x > 8 || y <= 0 || y > 8) {
                        continue;
                    }

                    if(!visit[x][y] && board[x][y] == 0) {
                        que.offer(new Loc(x,y,temp.count+1));
                        visit[x][y] = true;
                    }
                }

            }
            scroll();
        }
        return false;
    }

    public static void scroll() {

        for (int i = 8; i > 0; i--) {
            board[i] = board[i-1];
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
