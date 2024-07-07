package org.example.백준.알고리즘기초_2_강의.그래프.단지번호붙이기_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] aparts = new int[25*25];
    static int apartNum = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - 48;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    arr[i][j] = 0;
                    apartNum++;
                    solve(i, j);
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(apartNum);

        for(int i=0; i<aparts.length; i++){
            if(aparts[i] == 0){
            }else{
                System.out.println(aparts[i]);
            }
        }

    }
    static void solve(int a , int b) {
        Queue<int[]> que = new LinkedList<>();
        aparts[apartNum]++;
        que.offer(new int[] {a,b});

        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int x = temp[0];
            int y = temp[1];

            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if(newX < 0 || newX >= N || newY < 0 || newY >= N) {
                    continue;
                }

                if(arr[newX][newY] == 1) {
                    aparts[apartNum]++;
                    que.offer(new int[] {newX,newY});
                    arr[newX][newY] = 0;
                }
            }
        }
    }
}
