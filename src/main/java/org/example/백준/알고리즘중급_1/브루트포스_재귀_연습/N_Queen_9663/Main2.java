package org.example.백준.알고리즘중급_1.브루트포스_재귀_연습.N_Queen_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int[] arr;
    static int N;
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        N = Integer.parseInt(str);

        arr = new int[N];

        dfs(0);
        System.out.println(count);


    }
    public static void dfs(int depth) {

        if(depth == N) {
            count++;
            return;
        }

        for(int i = 0 ; i < N; i++) {
            arr[depth] = i;
            if(possible(depth)) {
                dfs(depth+1);
            }
        }
    }

    public static boolean possible(int col) {

        for(int i = 0 ; i < col ; i++) {
            //행에 일치하는게 있는지 판별
            if(arr[i]==arr[col]) {
                return false;
            }
            //대각선에 일치하는게 있는지 판별 : 대각선의 경우 행과 열의 차이가 같으면 대각선에 있음을 의미!
            else if(Math.abs(col-i) == Math.abs(arr[col]-arr[i])) {
                return false;
            }

        }

        return true;
    }
}
