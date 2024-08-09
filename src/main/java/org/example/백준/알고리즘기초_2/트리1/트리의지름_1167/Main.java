package org.example.백준.알고리즘기초_2.트리1.트리의지름_1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] list;
    static int ans = 0;
    static boolean[] check;
    static int node;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            while (true) {
                int b = Integer.parseInt(st.nextToken());

                if(b == -1) {
                    break;
                }

                list[a].add(b);
            }
        }

        check[1] = true;
        solve(1, 0);
        check[1] = false;

        check[node] = true;
        solve(node, 0);
        check[node] = false;



        System.out.println(ans);
    }
    static void solve(int a, int length) {
        for (int i = 0; i < list[a].size(); i++) {
            int temp = list[a].get(i);
            i++;
            if(!check[temp]) {
                check[temp] = true;
                solve(temp, length + list[a].get(i));
                check[temp] = false;
            }
        }

        if(ans < length) {
            ans = length;
            node = a;
        }
    }
}
