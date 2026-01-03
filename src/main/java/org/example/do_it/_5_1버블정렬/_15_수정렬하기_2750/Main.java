package org.example.do_it._5_1버블정렬._15_수정렬하기_2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0 ; i < N-1; i++) {
            for(int j = 1 ; j < N-i ; j++) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        for(int num : arr) {
            System.out.println(num);
        }
    }
}
