package org.example.do_it._6_1깊이우선탐색DFS._24_신기한소수_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

    }

    static void dfs(int a, int b) {
        if(b == N) {
            System.out.println(a);
            return ;
        }
        int num = a * 10;

        for(int i = 1; i <= 9 ; i++) {
            if(i % 2 == 0) {
                continue;
            }
            int temp = num + i;
            boolean flag = true;
            for(int j = 2 ; j <= temp / 2 ; j++) {
                if(temp % j == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                dfs(temp, b+1);
            }
        }
    }
}
