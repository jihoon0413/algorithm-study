package org.example.do_it._5_6기수정렬._22_수정렬하기3_10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();
        sort(5);
        // Arrays.sort(arr);

        for(int i = 0 ; i < N ; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void sort(int maxSize) {
        int temp1 = 1;
        for(int i = 1 ; i <= maxSize ; i++) {

            int[] bucket = new int[10];
            int[] copy = new int[N];

            for(int j = 0 ; j < N ; j++) {
                int idx = (arr[j] / temp1) % 10;
                bucket[idx]++;
            }

            for(int j = 1 ; j < 10 ; j++) {
                bucket[j] += bucket[j-1];
            }

            for(int j = N-1 ; j >= 0 ; j--) {
                int idx = (arr[j] / temp1) % 10;
                copy[--bucket[idx]] = arr[j];
            }

            for(int j = 0 ; j < N ; j++) {
                arr[j] = copy[j];
            }
            temp1 *= 10;
        }
    }
}

