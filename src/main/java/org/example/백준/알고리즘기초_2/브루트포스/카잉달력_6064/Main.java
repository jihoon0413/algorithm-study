package org.example.백준.알고리즘기초_2.브루트포스.카잉달력_6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken())-1;
            y = Integer.parseInt(st.nextToken())-1;
            int ans = -2;

            for(int j = x ; j < (M*N) ; j+=M) {

                if(j % N == y) {
                    ans = j;
                    break;
                }
            }

            System.out.println(ans+1);

        }

    }
}
