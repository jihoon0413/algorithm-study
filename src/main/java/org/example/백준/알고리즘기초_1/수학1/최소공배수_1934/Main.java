package org.example.백준.알고리즘기초_1.수학1.최소공배수_1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        for( int i = 0 ; i < c ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int a2 = a;
            int b2 = b;
            int max;

            if (a < b) {
                int temp = b;
                b = a;
                a = temp;
            }

            while (b2 != 0) {
                int m = a2 % b2;
                a2 = b2;
                b2 = m;
            }

            max = a2;

            System.out.println(a * b / max);
        }
    }
}
