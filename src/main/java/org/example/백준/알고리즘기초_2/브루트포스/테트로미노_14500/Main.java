package org.example.백준.알고리즘기초_2.브루트포스.테트로미노_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;
    static int[][] arr;
    static boolean[][] visit;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int row;
    static int col;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        arr = new int[row+1][col+1];
        visit = new boolean[row+1][col+1];

        for(int i = 1 ; i <= row ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= col ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 1 ; i <= row ; i++) {
            for(int j = 1 ; j <= col ; j++) {

                visit[i][j] = true;
                solve(i,j,arr[i][j],1);
                visit[i][j] = false;

            }
        }

        System.out.println(ans);


    }
    static void solve(int x, int y , int sum, int count) {

        if(count == 4) {
            ans = Math.max(ans, sum);
        } else {
            for(int i = 0 ; i < 4 ; i++) {
                int dx = x+mx[i];
                int dy = y+my[i];

                if(dx < 1 || dx > row || dy < 1 || dy > col) {
                    continue;
                }

                if(!visit[dx][dy]) {

                    if(count == 2) {
                        visit[dx][dy] = true;
                        solve(x,y,sum + arr[dx][dy],count + 1);
                        visit[dx][dy] = false;
                    }

                    visit[dx][dy] = true;
                    solve(dx,dy,sum + arr[dx][dy],count + 1);
                    visit[dx][dy] = false;
                }
            }
        }
    }
}
