package org.example.백준.알고리즘중급_1.BFS_연습.벽부수고이동하기4_16946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] spaceMap;
    static int[][] spaceID;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        spaceMap = new int[N][M];
        spaceID = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N ; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int temp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !check[i][j]) {
                    checkSpace(i, j, temp);
                    temp++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    map[i][j] = solve(i,j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]%10);
            }
            System.out.println();
        }

    }
    static void checkSpace(int a, int b, int num) {

        Queue<Space> que = new LinkedList<>();
        Queue<Space> tempQue = new LinkedList<>();

        int ans = 1;

        check[a][b] = true;
        que.offer(new Space(a,b,num));

        while (!que.isEmpty()) {

            Space space = que.poll();
            tempQue.offer(space);

            for (int i = 0; i < 4; i++) {
                int x = space.x + dx[i];
                int y = space.y + dy[i];

                if(x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                }

                if(map[x][y] == 0 && !check[x][y]) {
                    que.offer(new Space(x,y,num));
                    check[x][y] = true;
                    ans++;
                }
            }
        }

        while (!tempQue.isEmpty()) {
            Space space = tempQue.poll();
            spaceMap[space.x][space.y] = ans;
            spaceID[space.x][space.y] = space.num;
        }

    }


    static int solve(int a, int b) {
        List<Integer> Id = new ArrayList<>();
        int sum = 1;

        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];

            if(x < 0 || x >= N || y < 0 || y >= M) {
                continue;
            }

            if(map[x][y] == 0 && !Id.contains(spaceID[x][y])) {
                Id.add(spaceID[x][y]);
                sum += spaceMap[x][y];
            }
        }

        return sum;
    }

    public static class Space {

        int x;
        int y;
        int num;

        public Space(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

    }
}