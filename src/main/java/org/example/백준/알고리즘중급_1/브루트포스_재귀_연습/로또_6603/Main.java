package org.example.백준.알고리즘중급_1.브루트포스_재귀_연습.로또_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int N;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());

            if(N == 0) {
                break;
            }

            num = new int[N];
            check = new boolean[N];

            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            solve(0,0);

            System.out.println();

        }



    }
    static void solve(int idx, int count) {
        if(count == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (check[i]) {
                    sb.append(num[i]).append(" ");
                }
            }
            System.out.println(sb);
            return;
        }

        if(idx == N) {
            return;
        }

        check[idx] = true;
        solve(idx + 1, count + 1);
        check[idx] = false;

        solve(idx + 1, count);
    }
}
