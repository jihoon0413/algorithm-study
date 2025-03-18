package org.example.백준.알고리즘중급_1.분할정복.숫자카드2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] my;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        my = new int[N];
        for (int i = 0; i < N; i++) {
            my[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(my);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sb.append(findRight(temp) - findLeft(temp)).append(" ");
        }

        System.out.println(sb);
    }

    static int findRight(int num) {

        int left = 0;
        int right = N;

        while (left < right) {
            int middle = (left + right)/2;

            if(num < my[middle]) {
                right = middle;
            } else {
                left = middle+1;
            }

        }
        return left;
    }

    static int findLeft(int num) {
        int left = 0;
        int right = N;

        while (left < right) {
            int middle = (left + right)/2;
            if(num <= my[middle]) {
                right = middle;
            } else {
                left = middle+1;
            }
        }
        return left;
    }

}