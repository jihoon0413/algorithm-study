package org.example.do_it._10_4세그먼트트리._75_최솟값찾기_10868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int length = N;
        int treeHeight = 0;
        while(length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);  // 32
        int start_idx = treeSize / 2 - 1;  // 16 - 1


        tree = new int[treeSize + 1];
        for(int i = 1 ; i <= treeSize ; i++) {
            tree[i] = Integer.MAX_VALUE;
        }

        for(int i = start_idx + 1 ; i < start_idx + N + 1; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        setTree(treeSize);

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            getMin(s + start_idx, e + start_idx);
        }
    }
    static void getMin(int s, int e) {
        int min = Integer.MAX_VALUE;
        while(s <= e) {
            if(s % 2 == 1) {
                min = Math.min(min, tree[s]);
                s++;
            }
            if(e % 2 == 0) {
                min = Math.min(min, tree[e]);
                e--;
            }
            s /= 2;
            e /= 2;
        }
        System.out.println(min);
    }
    static void setTree(int a) {
        int idx = a;
        while(idx != 1) {
            tree[idx/2] = Math.min(tree[idx/2], tree[idx]);
            idx--;
        }
    }
}

