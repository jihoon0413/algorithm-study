package org.example.백준.알고리즘중급_1.브루트포스_비트마스트_연습.구슬탈출2_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] board;
    static boolean[][][][] check;
    static List<int[]> loc = new ArrayList<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        check = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == 'B' || str.charAt(j) == 'R' || str.charAt(j) == 'O'){
                    loc.add(new int[] {str.charAt(j),i,j});
                }
                if(str.charAt(j)=='#'){
                    check[i][j][i][j] = true;
                }
                board[i][j] = str.charAt(j);
            }
        }

        int rx = 0,ry=0,bx=0,by=0,ox=0,oy=0;

        for (int i = 0; i < 3; i++) {
            int[] temp = loc.get(i);

            switch (temp[0]) {
                case 'R':
                    rx = temp[1];
                    ry = temp[2];
                    break;
                case 'B':
                    bx = temp[1];
                    by = temp[2];
                    break;
                case 'O':
                    ox = temp[1];
                    oy = temp[2];
                    break;
            }
        }

        check[rx][ry][bx][by] = true;
        solve(rx, ry, bx, by, ox, oy, 0);
        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);

    }
    static void solve(int rx, int ry, int bx, int by, int ox, int oy, int count) {

        if(rx == ox && ry == oy) {
            if(bx == ox && by == oy) {
                return;
            }
            ans = Math.min(ans, count);
            return;
        }

        if(count >= 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[] temp = getLoc(rx,ry,bx,by, new int[] {dx[i],dy[i]});
            int nrx = temp[0];
            int nry = temp[1];
            int nbx = temp[2];
            int nby = temp[3];

            if(!check[nrx][nry][nbx][nby]) {
                check[nrx][nry][nbx][nby] = true;
                solve(nrx, nry, nbx, nby, ox, oy, count + 1);
                check[nrx][nry][nbx][nby] = false;
            }
        }

    }

    static int[] getLoc(int rx, int ry, int bx, int by, int[] way) {
        int nrx = rx;
        int nry = ry;
        int nbx = bx;
        int nby = by;
        int[] loc = new int[4];
        boolean r = false, b = false;

        while(true) {
            if (board[nrx][nry] == 'O' && !r) {
                loc[0] = nrx;
                loc[1] = nry;
                r = true;
            }
            if ((b && nrx == loc[2] && nry == loc[3] && !r && board[nrx][nry] != 'O') || (board[nrx][nry] == '#' && !r)) {
                loc[0] = nrx - way[0];
                loc[1] = nry - way[1];
                if(loc[0] == nbx && loc[1] == nby) {
                    loc[2] = loc[0] - way[0];
                    loc[3] = loc[1] - way[1];
                    b = true;
                }
                r = true;
            }
            if (board[nbx][nby] == 'O' && !b) {
                loc[2] = nbx;
                loc[3] = nby;
                b = true;
            }
            if ((r && nbx == loc[0] && nby == loc[1] && !b && board[nbx][nby] != 'O') ||(board[nbx][nby] == '#' && !b)) {
                loc[2] = nbx - way[0];
                loc[3] = nby - way[1];
                if(loc[2] == nrx && loc[3] == nry) {
                    loc[0] = loc[2] - way[0];
                    loc[1] = loc[3] - way[1];
                    r = true;
                }
                b = true;
            }

            if (r && b) {
                break;
            }

            if (!r) {
                nrx += way[0];
                nry += way[1];
            }
            if (!b) {
                nbx += way[0];
                nby += way[1];
            }
        }
        return loc;
    }
}
