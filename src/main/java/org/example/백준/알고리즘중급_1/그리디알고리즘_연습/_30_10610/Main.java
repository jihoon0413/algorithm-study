package org.example.백준.알고리즘중급_1.그리디알고리즘_연습._30_10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] num = new int[10];
        int count = str.length();
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            int temp = Integer.parseInt(String.valueOf(str.charAt(i)));
            sum += temp;
            num[temp]+=1;
        }

        if(num[0] == 0 || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 9; i >= 0 ; i--) {
            for (int j = 0; j < num[i]; j++) {
                sb.append(i);
            }
        }

        System.out.println(sb);

    }
}
