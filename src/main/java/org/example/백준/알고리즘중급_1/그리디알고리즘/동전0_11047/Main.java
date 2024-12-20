package org.example.백준.알고리즘중급_1.그리디알고리즘.동전0_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        int[] money = new int[N];
        int ans = 0;

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        while (goal != 0) {
            for (int i = N-1; i >= 0; i--) {
                if(money[i] <= goal) {
                    ans += goal/money[i];
                    goal %= money[i];
                }
            }
        }
        System.out.println(ans);
    }
}
