package org.example.백준.알고리즘기초_2_강의.재귀.맞춰봐_1248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N+1][N+1];
        ans = new int[N+1];

        String temp = br.readLine();
        int idx = 0;

        for(int i = 1 ; i <= N ; i++) {
            for( int j = i ; j <= N ; j++) {
                arr[i][j] = temp.charAt(idx);
                idx++;
            }
        }
        solve(1);

    }

    static void solve(int count) {

        if(count == N + 1) {
            for(int i = 1 ; i <= N ; i++) {
                System.out.print(ans[i] + " ");
            }
            System.exit(0);
            return;
        }

        if(arr[count][count] == '+') {
            temporary(1, 11, count);

        } else if (arr[count][count] == '-') {
            temporary(-10, 0, count);

        } else {
            temporary(-10 , 11 , count);
        }


    }

    static void temporary (int start , int end , int count) {
        for(int i = start ; i < end ; i++) {
            boolean flag = true;
            int temp = 0;
            ans[count] = i;

            for(int j = count ; j >= 1; j--) {
                temp += ans[j];
                if(!checkNum(arr[j][count],temp)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                ans[count] = i;
                solve(count+1);
            }

        }
    }

    static boolean checkNum(char idx, int num) {
        if(idx == '+') {
            return num > 0;
        } else if(idx == '-') {
            return num < 0;
        } else {
            return num == 0;
        }

    }

}
