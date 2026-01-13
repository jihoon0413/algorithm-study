package org.example.do_it._9_6플로이드워셜._64_가장빠른버스노선_11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                if(i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = 10000000;
                }
            }
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(arr[s][e] > w) arr[s][e] = w;
        }

        for(int k = 1 ; k <= N ; k++) {
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                if(arr[i][j] == 10000000) System.out.print("0 ");
                else System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
