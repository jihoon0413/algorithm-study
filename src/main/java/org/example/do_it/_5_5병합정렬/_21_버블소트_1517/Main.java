package org.example.do_it._5_5병합정렬._21_버블소트_1517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, temp;
    static int N;
    static long answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sort(0, N-1);

        // for(int i = 0 ; i < N ; i++) {
        //   System.out.print(arr[i] + " ");
        // }
        // System.out.println();
        System.out.print(answer);


    }

    public static void sort(int s, int e) {
        if(s >= e) {
            return;
        }
        int m = (s+e)/2;

        // if(e-s < 1) {
        //   return;
        // }
        // int m = s + (e-s) / 2;

        sort(s,m);
        sort(m+1,e);

        for(int i = s ; i <= e ; i++) {
            temp[i] = arr[i];
        }

        int idx1 = s;
        int idx2 = m+1;
        int index = s;

        while(idx1 <= m && idx2 <= e) {
            if(temp[idx1] > temp[idx2]) {
                answer += (idx2 - index);
                arr[index++] = temp[idx2++];
            } else {
                arr[index++] = temp[idx1++];
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

