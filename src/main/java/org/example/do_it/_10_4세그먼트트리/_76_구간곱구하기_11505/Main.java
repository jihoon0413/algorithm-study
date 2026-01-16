package org.example.do_it._10_4세그먼트트리._76_구간곱구하기_11505;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static int size;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int length = N;
        int treeHeight = 0;
        while(length > 0) {
            length /= 2;
            treeHeight++;
        }

        size = (int) Math.pow(2, treeHeight + 1); // height = 3, size = 16 (2^4)
        int start_idx = size/2 - 1; // 8 - 1

        tree = new long[size+1];
        for(int i = 1 ; i <= size ; i++) {
            tree[i] = 1;
        }
        for(int i = start_idx + 1 ; i < start_idx + N + 1 ; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        setTree(size);

        // for(long temp : tree) {
        //   System.out.print(temp + " ");
        // }
        // System.out.println();

        for(int i = 0 ; i < M + K ; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(flag == 1) {
                change(s + start_idx,e);
            } else if(flag == 2) {

                // for(long temp : tree) {
                //   System.out.print(temp + " ");
                // }
                // System.out.println();
                // 곱 구하기
                getAns(s + start_idx,e + start_idx);
            }
        }

        // System.out.println(answer);

    }

    static void change(int a, int b) {
        int p = a;
        long old = tree[p];
        tree[a] = b;
        while(p != 1) {
            p /= 2;
            tree[p] = (tree[2*p] * tree[2*p + 1]) % 1000000007;

        }

    }

    static void getAns(int a, int b) {
        int s = a;
        int e = b;
        long ans = 1;
        // System.out.println(a + " : "  + b);
        while(s <= e) {
            if(s % 2 == 1) {
                ans = ans * tree[s] % 1000000007;
                s++;
            }
            if(e % 2 == 0) {
                ans = ans * tree[e] % 1000000007;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        System.out.println(ans);
    }

    static void setTree(int a) {
        int idx = a;
        while(idx != 1) {
            tree[idx/2] = tree[idx/2] *tree[idx] % 1000000007;
            idx--;
        }
    }
}
