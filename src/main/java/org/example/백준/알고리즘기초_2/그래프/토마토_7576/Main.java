package org.example.백준.알고리즘기초_2.그래프.토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] check;
    static boolean[] day;
    static int ans = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int m;
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());



        arr = new int[n][m];
        check = new boolean[n][m];
        day = new boolean[n*m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        solve();

        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }

        for(boolean temp : day) {
            if(!temp) {
                break;
            }
            ans++;
        }

        if(flag) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }

    }


    static void solve() {
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    que.offer(new int[] {i,j,0});
                }
            }
        }
        while(!que.isEmpty()) {
            int[] temp = que.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            int tempDay = temp[2];

            for (int i = 0; i < 4; i++) {
                int x = tempX + dx[i];
                int y = tempY + dy[i];

                if(x < 0 || x >= n || y < 0 || y >= m) {
                    continue;
                }

                if(arr[x][y] == 0) {
                    que.offer(new int[] {x,y,tempDay+1});
                    if(!day[tempDay]) {
                        day[tempDay] = true;
                    }
                    arr[x][y] = 1;
                }
            }

        }
    }
}
