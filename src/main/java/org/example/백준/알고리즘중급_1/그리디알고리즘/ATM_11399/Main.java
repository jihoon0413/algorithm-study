package org.example.백준.알고리즘중급_1.그리디알고리즘.ATM_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = N;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        int sum = 0;
        for (int i = 0; i < count; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        for (int i = 0; i < count; i++) {
            sum += num[i]*N;
            N--;
        }

        System.out.println(sum);
    }
}
