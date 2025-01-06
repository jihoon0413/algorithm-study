package org.example.백준.알고리즘중급_1.그리디알고리즘.동전뒤집기_1285;

import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n;
    static boolean[][] coins;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    public static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        coins = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                if(str.charAt(j) == 'H') {
                    coins[i][j] = true;
                }
            }
        }
    }

    public static void solution() throws IOException {
        int ans = Integer.MAX_VALUE;
        for (int bitCase = 0; bitCase < (1 << n); bitCase++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                    boolean temp = coins[i][j];
                    if((bitCase & (1<<i)) != 0) {
                        temp = !temp;
                    }
                    if(!temp) {
                        count++;
                    }
                }
                sum += Math.min(count, n-count);
            }
            
            ans = Math.min(ans,sum);
        }
        System.out.println(ans);
    }
}