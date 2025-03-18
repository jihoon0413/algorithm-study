package org.example.백준.알고리즘중급_1.분할정복.숫자카드_10815;

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
            sb.append(findNum(Integer.parseInt(st.nextToken()))).append(" ");
        }

        System.out.println(sb);
    }

    public static int findNum(int num) {

        int left = 0;
        int right = N-1;

        while (left <= right) {
            int middle = (left + right)/2;
            if( num > my[middle]) {
                left = middle + 1;
            } else if (num < my[middle]) {
                right = middle -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
