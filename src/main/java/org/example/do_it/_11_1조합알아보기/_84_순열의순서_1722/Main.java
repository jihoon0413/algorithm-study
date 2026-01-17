package org.example.do_it._11_1조합알아보기._84_순열의순서_1722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[N+1];
        long[] F = new long[N+1];
        int[] S = new int[21];

        F[0] = 1;
        for(int i = 1 ; i <= N ; i++){
            F[i] = F[i-1]*i;
        }

        st = new StringTokenizer(br.readLine());

        int Q = Integer.parseInt(st.nextToken());

        if(Q == 1) {
            long K = Long.parseLong(st.nextToken());

            for(int i = 1 ; i <= N ; i++) {

                int cnt = 1;
                for(int j = 1; j <= N ; j++) {
                    if(visited[j]) continue;

                    if(K <= cnt * F[N-i]) {
                        S[i] = j;
                        visited[j] = true;
                        K -= ((cnt-1) * F[N-i]);
                        break;
                    }
                    cnt++;
                }
            }
            for(int i = 1; i <= N ; i++) {
                System.out.print(S[i] + " ");
            }

        } else if (Q == 2) {

            for(int i = 1 ; i<= N ; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            long K = 1;
            for(int i = 1 ; i <= N ; i++) {
                long cnt = 0;
                for(int j = 1; j <= N ; j++) {
                    if(visited[j]) continue;

                    if(j <= S[i]) {
                        cnt++;
                    }
                }
                visited[S[i]] = true;
                K += (cnt-1) * F[N-i];
            }

            System.out.print(K);
        }
    }
}
