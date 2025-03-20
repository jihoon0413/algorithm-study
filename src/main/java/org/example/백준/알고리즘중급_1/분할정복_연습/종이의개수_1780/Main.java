package org.example.백준.알고리즘중급_1.분할정복_연습.종이의개수_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        ans = new int[3];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0,0,N);

        for (int i : ans) {
            System.out.println(i);
        }


    }

    static void solve (int x, int y, int size) {
        if(check(x,y,size)) {
            count(arr[x][y]);
            return;
        }

        int newSize = size/3;
        for (int i = x; i < x+size; i += newSize) {
            for (int j = y; j < y+size ; j += newSize) {
                solve(i,j,newSize);
            }
        }

    }

    static void count(int num) {
        if(num == -1) {
            ans[0]++;
        } else if(num == 0) {
            ans[1]++;
        } else if (num == 1) {
            ans[2]++;
        }
    }

    static boolean check(int x, int y, int size) {
        int idx = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(idx != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
