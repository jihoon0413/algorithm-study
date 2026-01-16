package org.example.do_it._10_3이진트리._73_트리순회하기_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N][2];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';

            if(right > 0 ) {
                arr[parent][0] = right;
            } else {
                arr[parent][0] = -1;
            }
            if(left > 0) {
                arr[parent][1] = left;
            } else {
                arr[parent][1] = -1;
            }
        }

        front(0);
        System.out.println();
        mid(0);
        System.out.println();
        rear(0);

    }

    static void front(int a) {

        System.out.print((char) (a + 'A'));

        for(int child : arr[a]) {
            if(child != -1) {
                front(child);
            }
        }
    }

    static void mid(int a) {

        if(arr[a][0] != -1) {
            mid(arr[a][0]);
        }
        System.out.print((char) (a + 'A'));
        if(arr[a][1] != -1) {
            mid(arr[a][1]);
        }

    }

    static void rear(int a) {

        for(int child : arr[a]) {
            if(child != -1) {
                rear(child);
            }
        }
        System.out.print((char) (a + 'A'));
    }

}

