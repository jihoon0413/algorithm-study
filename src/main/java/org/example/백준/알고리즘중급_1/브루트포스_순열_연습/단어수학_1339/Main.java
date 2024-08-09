package org.example.백준.알고리즘중급_1.브루트포스_순열_연습.단어수학_1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] alpha = new int[26];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int p = str.length();
            for (int j = 0; j < str.length(); j++) {
                int a = str.charAt(j) - 'A';
                alpha[a] += (int) Math.pow(10,--p);
            }
        }

        int ans = 0;
        Arrays.sort(alpha);

        int temp = 9;
        for (int i = 25; i >= 0; i--) {
            if(alpha[i] == 0) {
                break;
            }
            ans += alpha[i]*temp--;
        }

        System.out.println(ans);

    }
}
