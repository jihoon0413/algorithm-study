package org.example.백준.알고리즘중급_1.브루트포스_비트마스트_연습.가르침_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] words;
    static boolean[] alpha = new boolean[26];
    static int N,K;
    static int ans = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        if(K < 5) {
            System.out.println(0);
        } else {

            alpha = new boolean[26];
            alpha[0] = true;
            alpha['c' - 'a'] = true;
            alpha['i' - 'a'] = true;
            alpha['n' - 'a'] = true;
            alpha['t' - 'a'] = true;

            solve(0,5);

            System.out.println(ans);
        }

    }
    static void solve(int index, int count) {

        if (count == K) {
            int temp = 0;

            for (int i = 0; i < N; i++) {
                String word = words[i];
                boolean flag = true;
                for (int j = 0; j < word.length(); j++) {
                    if (!alpha[word.charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    temp++;
                }
            }
            ans = Math.max(ans, temp);
            return;
        }

        for(int i = index; i < 26; i++) {
            if(!alpha[i]) {
                alpha[i] = true;
                solve(i, count + 1);
                alpha[i] = false;
            }
        }


    }
}
