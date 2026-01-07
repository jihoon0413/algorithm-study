package org.example.do_it._6_4이진탐색._34_k번쨰수_1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int start = 1;
        int end = K;

        while(start <= end) {
            int middle = (start + end)/2;
            int cnt = 0;
            for(int i = 1 ; i <= N ; i++) {
                cnt += Math.min(middle/i, N);
            }

            if(cnt >= K) { // cnt == k 일 경우 현재 값이 정답일 수 있음
                end = middle - 1;
                answer = middle; // 그래서 answer를 업데이트
            } else {
                // answer = middle;
                start = middle + 1;
            }

            // if(cnt < K) {
            //   start = middle + 1;
            //   answer = middle;
            // } else {
            //   // answer = middle;
            //   end = middle - 1;
            // }

        }
        System.out.println(answer);


    }
}
