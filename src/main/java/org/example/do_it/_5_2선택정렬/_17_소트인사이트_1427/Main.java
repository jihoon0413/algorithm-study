package org.example.do_it._5_2선택정렬._17_소트인사이트_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String str = br.readLine();

        int size = str.length();
        int[] arr = new int[size];

        for(int i = 0 ; i < size ; i++) {
            arr[i] = str.charAt(i)-'0';
        }

        for(int i = 0 ; i < size - 1; i++ ){
            int max = Integer.MIN_VALUE;
            int idx = i;
            for(int j = i ; j < size ; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    idx = j;
                }
            }
            if(i != idx) {
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }
        }

        for(int i = 0 ; i < size ; i++) {
            System.out.print(arr[i]);
        }
    }
}