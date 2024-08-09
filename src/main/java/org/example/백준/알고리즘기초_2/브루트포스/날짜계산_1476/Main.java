package org.example.백준.알고리즘기초_2.브루트포스.날짜계산_1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 1;
        int e2 = 1, s2 = 1, m2 = 1;

        while(true) {

            if(e2 == e && s2 == s && m2 == m) {
                System.out.println(ans);
                return;
            } else {
                e2++;
                s2++;
                m2++;
            }

            if(e2 == 16) {
                e2 = 1;
            }
            if(s2 == 29) {
                s2 = 1;
            }
            if(m2 == 20) {
                m2 = 1;
            }
            ans++;
        }
    }
}
