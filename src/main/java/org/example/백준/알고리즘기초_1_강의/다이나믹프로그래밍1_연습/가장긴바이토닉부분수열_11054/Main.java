package org.example.백준.알고리즘기초_1_강의.다이나믹프로그래밍1_연습.가장긴바이토닉부분수열_11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        int[] arr = new int[a+1];
        int[] dpFront = new int[a+1];
        int[] dpBack = new int[a+1];
        int ans = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= a ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= a ; i++) {
            dpFront[i] = 1;
            for(int j = 1 ; j < i ; j++) {
                if(arr[i] > arr[j] && dpFront[i] <= dpFront[j]) {
                    dpFront[i] = dpFront[j] + 1;
                }
            }

            int temp = a + 1 - i;

            dpBack[temp] = 1;
            for(int j = a ; j > temp ; j--) {
                if(arr[temp] > arr[j] && dpBack[temp] <= dpBack[j]) {
                    dpBack[temp] = dpBack[j] + 1;
                }
            }
        }

        for(int i = 1 ; i <= a ; i++) {
            ans = Math.max(ans, dpFront[i] + dpBack[i] - 1);
        }

        System.out.println(ans);

    }
}
