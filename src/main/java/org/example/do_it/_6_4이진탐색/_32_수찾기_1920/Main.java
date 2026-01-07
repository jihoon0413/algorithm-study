package org.example.do_it._6_4이진탐색._32_수찾기_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++) {
            int a = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int s = 0, e = N-1;

            while(s <= e) {

                int m = (s+e)/2;

                if(arr[m] < a) {
                    s = m + 1;
                } else if(arr[m] > a) {
                    e = m - 1;
                } else {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
