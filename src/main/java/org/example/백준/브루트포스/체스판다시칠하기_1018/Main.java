package org.example.백준.브루트포스.체스판다시칠하기_1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        int min = 64;

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int k = 0; k <= m - 8; k++) {
                int temp = countPaint(i,k,'B');
                if(min > temp){
                    min = temp;
                };

                temp = countPaint(i,k,'W');
                if(min > temp){
                    min = temp;
                };
            }
        }

        System.out.println(min);

    }
    static int countPaint(int n, int m, char startWith) {
        int count = 0;

        for (int j = n; j < n + 8; j++) {
            for (int u = m; u < m + 8; u++) {

                if((j-n)%2 == 0 && (u-m)%2 == 0 && board[j][u] != startWith) {
                    count++;
                } else if((j-n)%2 == 1 && (u-m)%2 == 1 && board[j][u] != startWith) {
                    count++;
                } else if((j-n)%2 == 0 && (u-m)%2 == 1 && board[j][u] == startWith) {
                    count++;
                } else if((j-n)%2 == 1 && (u-m)%2 == 0 && board[j][u] == startWith) {
                    count++;
                }
            }
        }

        return count;

    }

}
