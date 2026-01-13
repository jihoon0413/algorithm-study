package org.example.do_it._9_6플로이드워셜._66_케빈베이컨의6단계_1389;

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

        int[][] arr = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                arr[i][j] = 1000000;
            }
        }

        for(int i = 1 ; i <= M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;

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

        // for(int i = 1 ; i <= N ; i++) {
        //   for(int j = 1; j <= N ; j++) {
        //     System.out.print(arr[i][j] + " ");
        //   }
        //   System.out.println();
        // }

        int min = 1000000;
        for(int i = 1 ; i <= N ; i++) {
            int temp = 0;
            for(int j = 1; j <= N ; j++) {
                temp += arr[i][j];
            }
            if(min > temp) {
                min = temp;
                answer = i;
            }
        }

        System.out.println(answer);

    }
}
