package org.example.do_it._10_4세그먼트트리._74_구간합구하기_2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static int size;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());



        // N 1,000,000이기 때문에 이반적인 구간 합 N^2이면 2초 넘음
        // 세그먼트를 통해 logN으로 구해야함
        // k값 구하기

        int treeHeight = 0;
        int length = N;

        while(length != 0) {
            length /= 2;
            treeHeight++;
        }

        size = (int) Math.pow(2,treeHeight + 1);
        int start_idx = size / 2;
        arr = new long[size + 1];

        for(int i = start_idx  ; i < start_idx + N ; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        setTree(size);

        for(int i = 0 ; i < M + K ; i++) {
            st = new StringTokenizer(br.readLine());

            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if(flag == 1) {
                // 바꾸기
                change(a + start_idx - 1, b);
            } else if(flag == 2) {
                // 구간 합
                sum(a + start_idx - 1, (int) b + start_idx - 1);
            }
        }


    }

    static void change(int a, long b) {
        long diff = b - arr[a];
        while(a > 0) {
            arr[a] = arr[a] + diff;
            a /= 2;
        }
    }

    static void sum(int a, int b) {

        int s = a;
        int e = b;
        long sum = 0;

        while(s <= e) {
            if(s % 2 == 1) {
                sum += arr[s];
                s++;
            }
            if(e % 2 == 0) {
                sum += arr[e];
                e--;
            }

            s /= 2;
            e /= 2;
        }
        System.out.println(sum);
    }

    static void setTree(int a) {
        while(a != 1) {
            arr[a/2] += arr[a];
            a--;
        }
    }
}
