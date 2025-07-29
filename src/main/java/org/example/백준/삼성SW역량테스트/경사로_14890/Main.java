package org.example.백준.삼성SW역량테스트.경사로_14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, L;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(rowRoute(i)) ans++;
            if(colRoute(i)) ans++;
        }

        System.out.println(ans);
    }

    public static boolean rowRoute(int x) {
        boolean[] check = new boolean[N];

        for (int i = 0; i < N-1; i++) {
            int diff = map[x][i+1] - map[x][i];


            if(diff == 0) {
                continue;
            }

            if(Math.abs(diff) != 1) {
                return false;
            }
            if(diff == 1) {
                for (int j = 0; j < L; j++) {
                    if(i-j < 0 || check[i-j]) return false;
                    if(map[x][i] != map[x][i-j]) return false;
                    check[i-j] = true;
                }
            } else if (diff == -1) {
                for (int j = 1; j <= L; j++) {
                    if(i+j >= N || check[i+j]) return false;
                    if(map[x][i] - 1 != map[x][i+j]) return false;
                    check[i+j] = true;
                }
            }
        }
        return true;
    }

    public static boolean colRoute(int y) {
        boolean[] check = new boolean[N];

        for (int i = 0; i < N-1; i++) {
            int diff = map[i+1][y] - map[i][y];


            if(diff == 0) {
                continue;
            }

            if(Math.abs(diff) != 1) {
                return false;
            }
            if(diff == 1) {
                for (int j = 0; j < L; j++) {
                    if(i-j < 0 || check[i-j]) return false;
                    if(map[i][y] != map[i-j][y]) return false;
                    check[i-j] = true;
                }
            } else if (diff == -1) {
                for (int j = 1; j <= L; j++) {
                    if(i+j >= N || check[i+j]) return false;
                    if(map[i][y] - 1 != map[i+j][y]) return false;
                    check[i+j] = true;
                }
            }
        }
        return true;
    }

}
