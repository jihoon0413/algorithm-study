package org.example.백준.알고리즘기초_2.재귀.암호만들기_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[] arr;
    static int L;
    static int C;
    static char[] temp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C+1];
        temp = new char[L+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= C ; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        solve(0, 0,0, 1);

        System.out.println(sb);

    }

    static void solve(int a, int b, int count, int start) {
        if(count == L) {
            if(a >= 1 && b >=2) {
                for(int i = 1 ; i <= L ; i++) {
                    sb.append(temp[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = start; i <= C ; i++) {
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                temp[count+1] = arr[i];
                solve(a+1, b, count + 1 , i+1);
            } else {
                temp[count+1] = arr[i];
                solve(a, b+1, count+1, i+1);
            }
        }
    }
}
