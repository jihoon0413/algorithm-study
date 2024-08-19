package org.example.백준.알고리즘중급_1.브루트포스_재귀_연습.에너지모으기_16198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] check;
    static int N;
    static int ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        check = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve(0,0);

        System.out.println(ans);

    }

    static void solve(int sum, int count) {

        if(count == N-2) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 2; i < N ; i++) {
            if(!check[i]) {
                check[i] = true;
                int temp = getAfter(i) * getBefore(i);
                solve(sum + temp,count+1);
                check[i] = false;
            }
        }


    }

    static int getBefore(int idx) {
        int before = idx;
        while (check[before]) {
            before--;
        }
        return arr[before];
    }

    static int getAfter(int idx) {
        int after = idx;
        while (check[after]) {
            after++;
        }
        return arr[after];
    }
}
