package org.example.백준.알고리즘중급_1.브루트포스_재귀_연습.두동전_16197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static Coin[] coins = new Coin[2];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int M;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        
        int temp = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
                if(str.charAt(j)== 'o') {
                    coins[temp] = new Coin(i,j);
                    temp++;
                }
            }
        }
        solve(0);

        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }
    static class Coin {
        int x;
        int y;

        Coin(int x, int y) {
           this.x = x;
           this.y = y;
        }
    }

    static void solve(int count) {

        int tempX1 = coins[0].x;
        int tempY1 = coins[0].y;
        int tempX2 = coins[1].x;
        int tempY2 = coins[1].y;

        if(count == 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x1 = tempX1 + dx[i];
            int y1 = tempY1 + dy[i];
            int x2 = tempX2 + dx[i];
            int y2 = tempY2 + dy[i];
            int drop = 0;

            if(x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) {
                x1 = tempX1;
                y1 = tempY1;
                drop++;
            }
            if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) {
                x2 = tempX2;
                y2 = tempY2;
                drop++;
            }

            if(drop == 1) {
                ans = Math.min(ans, count+1);
                return;
            } else if (drop == 2) {
                continue;
            }

            if(arr[x1][y1] == '#') {
                x1 = tempX1;
                y1 = tempY1;
            }


            if(arr[x2][y2] == '#') {
                x2 = tempX2;
                y2 = tempY2;
            }

            coins[0].x = x1;
            coins[0].y = y1;
            coins[1].x = x2;
            coins[1].y = y2;
            solve(count+1);

        }
    }
}
