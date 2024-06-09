package org.example.백준.알고리즘기초_2_강의.재귀.부등호_2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static String[] arr;
    static boolean[] check = new boolean[10];
    static StringBuilder sb;
    static int[] ans;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        arr = new String[K];
        ans = new int[K+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < K ; i++) {
            arr[i] = st.nextToken();
        }

        for(int i = 0 ; i <= 9 ; i++) {
            sb = new StringBuilder();
            check[i] = true;
            ans[0] = i;
            solve(1, i);
            check[i] = false;
        }

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));

    }
    static void solve(int count, int pre) {

        if(count == K+1) {
            for(int i = 0 ; i <= K ; i++) {
                sb.append(ans[i]);
            }
            list.add(String.valueOf(sb));
            sb.setLength(0);
            return;
        }

        for(int i = 0 ; i <= 9 ; i++) {
            if(Objects.equals(arr[count-1], "<")) {
                    if(pre < i && !check[i]) {
                        check[i] = true;
                        ans[count] = i;
                        solve(count+1, i);
                        check[i] = false;
                    }
            } else {
                if(pre > i && !check[i]) {
                    check[i] = true;
                    ans[count] = i;
                    solve(count+1, i);
                    check[i] = false;
                }
            }

        }

    }

}
