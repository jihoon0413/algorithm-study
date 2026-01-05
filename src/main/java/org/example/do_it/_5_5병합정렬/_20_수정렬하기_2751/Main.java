package org.example.do_it._5_5병합정렬._20_수정렬하기_2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int[] temp;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];


        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sort(0,N-1);

        for(int i = 0 ; i < N ; i++) {
            System.out.println(arr[i]);
        }


    }
    public static void sort(int s, int e) {
        if(s >= e) {
            return;
        }

        int m = (s + e)/2;

        sort(s, m);
        sort(m+1, e);

        for(int i = s; i <= e ; i++) {
            temp[i] = arr[i];
        }

        int idx1 = s;
        int idx2= m+1;
        int index = s;


        while(idx1 <= m && idx2 <= e) {
            if(temp[idx1] < temp[idx2]) {
                arr[index++] = temp[idx1++];
            } else {
                arr[index++] = temp[idx2++];
            }
        }

        while(idx1 <= m) {
            arr[index++] = temp[idx1++];
        }

        while(idx2 <= e) {
            arr[index++] = temp[idx2++];
        }

    }
}
