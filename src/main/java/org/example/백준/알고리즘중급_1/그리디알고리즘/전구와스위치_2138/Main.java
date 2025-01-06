package org.example.백준.알고리즘중급_1.그리디알고리즘.전구와스위치_2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] nowA = new int[N];
        int[] nowB = new int[N];
        int[] goal = new int[N];
        int countA = 1;
        int countB = 0;
        int ans = Integer.MAX_VALUE;

        String str = br.readLine();
        for (int i = 0; i < N; i++) {
            nowA[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            nowB[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        str = br.readLine();
        for (int i = 0; i < N; i++) {
            goal[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        switching(nowA, 0);

        for (int i = 1; i < N; i++) {
            if(nowA[i-1] != goal[i-1]) {
                switching(nowA, i);
                countA++;
            }
            if(nowB[i-1] != goal[i-1]) {
                switching(nowB, i);
                countB++;
            }
        }

        if(nowA[N-1] == goal[N-1]) {
            ans = Math.min(ans, countA);
        }

        if(nowB[N-1] == goal[N-1]) {
            ans = Math.min(ans, countB);
        }

        if(ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
    }

    static void switching(int[] now, int i) {
        if(i==0) {
            now[0] = now[0]==0?1:0;
            now[1] = now[1]==0?1:0;
        } else if (i == N-1) {
            now[N-2] = now[N-2]==0?1:0;
            now[N-1] = now[N-1]==0?1:0;
        } else {
            now[i-1] = now[i-1]==0?1:0;
            now[i] = now[i]==0?1:0;
            now[i+1] = now[i+1]==0?1:0;
        }
    }
}
