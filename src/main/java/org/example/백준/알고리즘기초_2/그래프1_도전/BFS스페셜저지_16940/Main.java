package org.example.백준.알고리즘기초_2.그래프1_도전.BFS스페셜저지_16940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] arr;
    static int[] seq;
    static boolean[] check;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        seq = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        if(seq[1] != 1) {
            System.out.println(0);
            return;
        }

        solve();

    }
    static void solve() {

        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        check[1] = true;
        int index = 2;

        while (!que.isEmpty()) {

            int val = que.poll();

            int size = 0;

            for(int a : arr[val]) {
                if(!check[a]) {
                    check[a] = true;
                    size++;
                }
            }
            for (int i = index; i < size + index; i++) {
                if(!check[seq[i]]) {
                    System.out.println(0);
                    return;
                } else {
                    que.offer(seq[i]);

                }
            }
            index += size;

        }
        System.out.println(1);
    }
}
