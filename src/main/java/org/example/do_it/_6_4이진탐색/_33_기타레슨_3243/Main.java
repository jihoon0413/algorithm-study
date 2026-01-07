package org.example.do_it._6_4이진탐색._33_기타레슨_3243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        A = new int[N];

        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s = 0;
        int e = 0;
        for(int i = 0 ; i< N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if(s < A[i]) s = A[i];
            e += A[i];
        }


        while(s <= e) {
            // System.out.println(s + " : " + e);
            int m = (s+e)/2;

            int count = 1;
            int temp = 0;
            for(int i = 0 ; i < N ; i++) {
                if(temp + A[i] > m) {
                    count++;
                    temp = A[i];
                } else {
                    temp += A[i];
                }
            }

            if(count <= M) {
                e = m - 1;
            } else if ( count > M) {
                s = m + 1;
            }
        }
        System.out.print(s);
    }

}
