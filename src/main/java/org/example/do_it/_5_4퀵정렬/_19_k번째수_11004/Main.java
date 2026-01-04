package org.example.do_it._5_4퀵정렬._19_k번째수_11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sort(0, N-1, M-1);

        System.out.println(arr[M-1]);

    }

    public static void sort(int start, int end, int M) {

        if(start < end) {
            int pivot = partition(start, end);

            if(pivot == M) {
                return;
            }

            if(M < pivot) {
                sort(start, pivot-1, M);
            } else {
                sort(pivot+1, end, M);
            }
        }
    }

    public static int partition(int start, int end) {

        if(start + 1 == end) {
            if(arr[start] > arr[end]) {
                swap(start, end);
            }
            return end;
        }


        int pivot_index = (start+ end)/2;
        swap(start, pivot_index);
        int pivot_value = arr[start];
        int s = start+1;
        int e = end;

        while(s <= e) {
            while(s <= end && arr[s] < pivot_value) {
                s++;
            }
            while(e > start && arr[e] > pivot_value) {
                e--;
            }

            if(s <= e) {
                swap(s++,e--);
            }
        }

        arr[start] = arr[e];
        arr[e] = pivot_value;
        return e;

    }

    public static void swap(int s, int e) {
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }
}

