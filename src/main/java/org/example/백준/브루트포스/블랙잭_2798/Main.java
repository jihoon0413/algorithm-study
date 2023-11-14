package org.example.백준.브루트포스.블랙잭_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st  = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Integer[] num = new Integer[n];

        for(int i = 0 ; i < n ; i++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(num, Collections.reverseOrder());

        findCard(num, m);


    }

    static void findCard(Integer[] num, int m) {

        int ans = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < num.length - 2 ; i++) {
            for(int j = i+1; j < num.length - 1; j++) {
                for(int k = j+1 ; k <num.length; k++) {
                    int temp = num[i] + num[j] + num[k];
                    if(min > m - (temp) && temp <= m) {
                        min = m - (temp);
                        ans = temp;

                    }

                }
            }
        }

        System.out.println(ans);

    }
}
