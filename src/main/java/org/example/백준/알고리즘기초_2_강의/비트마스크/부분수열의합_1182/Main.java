package org.example.백준.알고리즘기초_2_강의.비트마스크.부분수열의합_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] check;
    static int ans;
    static int N;
    static int S;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        check = new boolean[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        solve(1, 0);

        if(S==0) {
            ans--;
        }

        System.out.println(ans);

    }
    static void solve(int index, int sum) {

        if(index == N+1) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        solve(index+1,sum + arr[index]);
        solve(index+1, sum);

    }
}

