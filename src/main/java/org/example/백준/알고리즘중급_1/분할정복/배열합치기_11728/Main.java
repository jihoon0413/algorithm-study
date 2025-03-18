package org.example.백준.알고리즘중급_1.분할정복.배열합치기_11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        for (int i = N; i < N+ M; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
