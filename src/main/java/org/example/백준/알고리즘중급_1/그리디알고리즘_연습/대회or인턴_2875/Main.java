package org.example.백준.알고리즘중급_1.그리디알고리즘_연습.대회or인턴_2875;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = 0;
        int remain;

        if(M+N > K) {
            ans = Math.min(M, N / 2);
            K -= (M+N) - ans*3;
            if( K > 0) {
                ans -= (K+2)/3;
            }
        }

        System.out.println(ans);

//        if(M > N/2) {
//            ans = N/2;
//            remain = M - ans;
//        } else {
//            ans = M;
//            remain = N - (ans*2);
//        }
//
//        K -= remain;
//
//        while(K > 0) {
//            ans--;
//            K -= 3;
//        }
//
//        if(ans < 0 ) {
//            ans = 0;
//        }
//        System.out.println(ans);
    }
}
