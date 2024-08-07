package org.example.백준.알고리즘기초_2.브루트포스.리모컨_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String N;
    static int M;
    static boolean [] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        M = Integer.parseInt(br.readLine());
        arr = new boolean[11];
        if (M > 0) {
            String [] inputs = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                arr[Integer.parseInt(inputs[i])] = true;
            }
        }

        int ans = Math.abs(Integer.parseInt(N) - 100);
        for (int i = 0; i < 1000001; i++) {
            int cnt = check(i);
            if (cnt != 0)
                ans = Math.min(ans, Math.abs(Integer.parseInt(N) - i) + check(i));
        }
        System.out.print(ans);
    }

    public static int check(int n) {
        if (n == 0) {
            if (arr[n])
                return 0;
            else
                return 1;
        }

        int cnt = 0;
        while (n > 0) {
            if (arr[n % 10])
                return 0;
            cnt++;
            n /= 10;
        }

        return cnt;
    }
}