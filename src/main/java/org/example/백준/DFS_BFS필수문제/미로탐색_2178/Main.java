package org.example.백준.DFS_BFS필수문제.미로탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
//    static int ans = Integer.MAX_VALUE;
//    static int[][] countArr;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1][M + 1];
        map = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
//                if (str.charAt(j - 1) == '1') {
//                    visit[i][j] = true;
//                }
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

//        dfs(1, 1, 0);
        bfs();

        System.out.println(map[N][M]);

//        System.out.println(ans);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void bfs() {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {1, 1});
        visit[1][1] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int nX;
            int nY;

            for (int i = 0; i < 4; i++) {
                nX = now[0] + dx[i];
                nY = now[1] + dy[i];

                if (nX < 1 || nX > N || nY < 1 || nY > M) {
                    continue;
                }
                if (visit[nX][nY] || map[nX][nY] == 0) {
                    continue;
                }

                que.add(new int[] {nX,nY});
                visit[nX][nY] = true;
                map[nX][nY] = map[now[0]][now[1]] + 1;
            }
        }
    }

//    static void dfs(int x, int y, int count) {
//
//        if (x == N && y == M) {
//            ans = Math.min(ans, count + 1);
//        } else if (visit[x][y]) {
//            if (countArr[x][y] == 0 || countArr[x][y] > count) {
//                count++;
//
//                countArr[x][y] = count;
//
//                for (int i = 0; i < 4; i++) {
//                    int nX = x + dx[i];
//                    int nY = y + dy[i];
//
//                    if (nX < 1 || nX > N || nY < 1 || nY > M) {
//                        continue;
//                    }
//
//                    if (visit[nX][nY]) {
//                        visit[x][y] = false;
//                        dfs(nX, nY, count);
//                        visit[x][y] = true;
//                    }
//
//                }
//            }
//        }
//    }
}
