package org.example.백준.알고리즘중급_1.브루트포스_순열_연습.연산자끼워넣기_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int[] cal = new int[4];
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        solve(num[0], 1);

        System.out.println(max);
        System.out.println(min);

    }
    static void solve(int temp , int idx) {

        if(idx == N) {
            max = Math.max(max, temp);
            min = Math.min(min, temp);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if(cal[i] != 0) {
                cal[i]--;
                switch (i) {
                    case 0: solve(temp + num[idx], idx + 1); break;
                    case 1: solve(temp - num[idx], idx + 1); break;
                    case 2: solve(temp * num[idx], idx + 1); break;
                    case 3: solve(temp / num[idx], idx + 1); break;
                }
                cal[i]++;
            }
        }

    }
}
