package org.example.백준.알고리즘중급_1.분할정복_연습.버블소트_1517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static long[] ans;
    static long count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new long[N];
        ans = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(0,N-1);

        System.out.println(count);
    }

    public static void merge_sort(int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            merge_sort(left, mid);
            merge_sort(mid + 1, right);
            merge(left, right);
        }
    }

    public static void merge(int left, int right) {
        int mid = (left + right)/2;
        int ls = left;
        int rs = mid + 1;
        int idx = left;

        while (ls <= mid && rs <= right) {
            if(arr[ls] > arr[rs]) {
                count += mid + 1 -ls;
                ans[idx++] = arr[rs++];
            } else {
                ans[idx++] = arr[ls++];
            }
        }

        while (ls <= mid) {
            ans[idx++] = arr[ls++];
        }

        while (rs <= right) {
            ans[idx++] = arr[rs++];
        }

        for (int i = left; i <= right; i++) {
            arr[i] = ans[i];
        }
    }
}
