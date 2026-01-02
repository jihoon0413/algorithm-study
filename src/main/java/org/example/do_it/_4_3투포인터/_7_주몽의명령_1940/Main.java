package org.example.do_it._4_3투포인터._7_주몽의명령_1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int startIdx = 1;
        int endIdx = N;

        while(startIdx < endIdx) {
            if(arr[startIdx] + arr[endIdx] < M) {
                startIdx++;
            } else if(arr[startIdx] + arr[endIdx] > M) {
                endIdx--;
            } else {
                answer++;
                startIdx++;
                endIdx--;
            }
        }

        System.out.println(answer);

    }
}
