package org.example.do_it._9_2유니온파인드._53_집합표현하기_1717;

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

        arr = new int[N+1];

        for(int i = 1 ; i <= N ; i++) {
            arr[i] = i;
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0) {
                union(b,c);

            } else {
                find(b);
                find(c);

                if(find(b) == find(c)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) {
            arr[rootB] = rootA;
        }
    }

    static int find(int a) {
        if(a == arr[a]) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}
