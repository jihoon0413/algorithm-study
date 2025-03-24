package org.example.백준.알고리즘중급_1.분할정복_연습.하노이탑이동순서_11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static int[] loc;
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        loc = new int[N+1];
        for (int i = 1; i <= N; i++) {
            loc[i] = 1;
        }
        solve(N, loc[N],3);
        System.out.println(count);
        System.out.println(sb);

    }

    static void solve(int layer, int now, int goal) {

        if(layer != 1) {
            int nextL = layer - 1;
            int nextLGoal = findGoal(now, goal);

            solve(nextL, loc[nextL], nextLGoal);
            sb.append(now).append(" ").append(goal).append("\n");
            loc[layer] = goal;
            count++;
            solve(nextL, loc[nextL], goal);

        } else {
            sb.append(now).append(" ").append(goal).append("\n");
            loc[layer] = goal;
            count++;
        }

    }

    static int findGoal(int now, int goal) {
        if(now == 1) {
            if(goal == 2) {
                return 3;
            } else {
                return 2;
            }
        } else if(now == 2) {
            if(goal == 1) {
                return 3;
            } else {
                return 1;
            }
        } else {
            if(goal == 1) {
                return 2;
            } else {
                return 1;
            }
        }
    }
}
