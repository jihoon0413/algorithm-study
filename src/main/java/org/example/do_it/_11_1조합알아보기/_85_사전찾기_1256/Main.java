package org.example.do_it._11_1조합알아보기._85_사전찾기_1256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] D = new int[201][201];

        for(int i = 0 ; i <= 200 ; i++) {
            D[i][0] = 1;
            D[i][1] = i;
            D[i][i] = 1;
        }

        for(int i = 2 ; i <= 200 ; i++) {
            for(int j = 1; j < i ; j++) {
                D[i][j] = D[i-1][j] + D[i-1][j-1];
                if(D[i][j] > 1000000000) D[i][j] = 1000000001;
            }
        }

        // for(int i = 0 ; i <= 200 ; i++) {
        //   for(int j = 0; j <= i ; j++) {
        //     System.out.print(D[i][j] + " ");
        //   }
        //   System.out.println();
        // }
        /*
        N+M C N를 구할 때
        점확식에서 D[i-1][j-1] 로가면 앞에 a
        D[i-1][j]로 가면 z를 붙이는 규칙이 있음

        N+M C M  == N+M C N

        N+M C M 일 때는
        D[i-1][j] = a
        D[i-1][j-1] = z가 붙는다

        이 문제는  N+M C M 를 활용해야 범위를 넘기지 않고 사용할 수 있음

        조합에서 법위를 벗어나면 이 성질를 활용해보자....
         */

        StringBuilder sb = new StringBuilder();

        if(K > D[N+M][N]) {
            System.out.println(-1);
        } else {
            while(N != 0 || M != 0) {

                if(K <= D[N+M-1][M]) { //a
                    sb.append("a");
                    N--;
                } else { //z
                    sb.append("z");
                    K -= D[N+M-1][M];
                    M--;
                }
            }
            System.out.println(sb);
        }
    }
}

