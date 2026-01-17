package org.example.do_it._11_1조합알아보기._86_선물전달_1947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int MOD = 1000000000;

        int N = Integer.parseInt(br.readLine());

        long[] D = new long[1000001];

        D[1] = 0;
        D[2] = 1;

        for (int i = 3; i <= N; i++) {
            D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % MOD; // D[i-2] 양방향 서로 교환,  D[i-1] 단방향 상대방 선물도 다른 곳에 사람에게 준경우

            /*
            어떤 수가 자기 자신을 빼고 다른 사람에게 주는 경우의 수 => (i-1)
            이때 내가 선물을 준 사람의 선물이 나에게 오면 전체 i에서 2개의 위치가 정해져 버림 :
             위치가 정해지지 않은 선물의 수 (i-2) -> 그러면 D[i-2]개수를 알 수 있음

            내가 선물을 준 사람의 선물이 오지 않으면 남은 선물의 개수가 (i-1) -> D[i-1]

            따라서 다음과 같은 점화식이 생김
            D[i] = (i-1) * (D[i-1] +  D[i-2]);
             */

            System.out.println(D[N]);
        }
    }
}

