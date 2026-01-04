package org.example.do_it._5_3삽입정렬._18_ATM_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] ans = new int[N];

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i < N ; i++) {
            int insert_index = i;
            int insert_value = arr[i];
            for(int j = i-1 ; j >= 0 ; j--) {
                if(insert_value > arr[j]) {
                    insert_index = j + 1;
                    break;
                }
                if(j == 0) {
                    insert_index = 0;
                }
            }
            for(int j = i ; j > insert_index ; j--) {
                arr[j] = arr[j-1];
            }
            arr[insert_index]=insert_value;

        }

        ans[0] = arr[0];
        for(int i = 1 ; i < N ; i++) {
            ans[i] = ans[i-1] + arr[i];
        }

        for(int i = 0 ; i < N ; i++) {
            answer += ans[i];
        }
        System.out.println(answer);
    }
}