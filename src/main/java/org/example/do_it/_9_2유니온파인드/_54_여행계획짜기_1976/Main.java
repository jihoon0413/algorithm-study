package org.example.do_it._9_2유니온파인드._54_여행계획짜기_1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] route;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        route = new int[N+1][N+1];
        arr = new int[N+1];

        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++) {
                route[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = i;
        }

        int[] plan = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M ; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                if(route[i][j] == 1) union(i,j);
            }
        }


        boolean flag = true;
        int temp = find(plan[0]);
        for(int i = 1 ; i < M ; i++) {
            if(temp != find(plan[i])) {
                flag = false;
                break;
            }
        }
        if(flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) arr[b] = a;
    }

    static int find(int a) {
        if(a == arr[a]) {
            return a;
        }

        return arr[a] = find(arr[a]);
    }
}
