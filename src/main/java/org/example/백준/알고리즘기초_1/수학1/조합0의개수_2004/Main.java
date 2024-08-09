package org.example.백준.알고리즘기초_1.수학1.조합0의개수_2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int two;
        int five;

        five = getFiveCount(n) - getFiveCount(n-m) - getFiveCount(m);
        two = getTwoCount(n) - getTwoCount(n-m) - getTwoCount(m);

        System.out.println(Math.min(five, two));

    }

    static int getFiveCount(int a) {
        int count = 0;
        while(a >=5) {
            count += a/5;
            a /= 5;
        }
        return count;
    }

    static int getTwoCount(int a) {
        int count = 0;
        while(a >=2) {
            count += a/2;
            a /= 2;
        }
        return count;
    }
}
