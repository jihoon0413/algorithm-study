package org.example.백준.알고리즘기초_2.순열.다음순열_10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(solve(arr)) {
            for(int a : arr) {
                sb.append(a).append(" ");
            }

        } else {
            sb.append(-1);
        }

        System.out.println(sb);

    }
    static boolean solve(int[] arr) {

        int i =arr.length-1;
        int j = arr.length-1;

        while(i > 0 && arr[i] < arr[i-1]) {
            i--;
        }

        if(i <= 0) {
            return false;
        }

        while(j >= i && arr[j] < arr[i-1]) {
            j--;
        }

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length-1;

        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
