package org.example.do_it._8_3유클리드호제법._45_최소공배수구하기_1934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            int a = a2, b = b2;
            while(a % b != 0) {
                // System.out.println(a + " : " + b);
                int c = a % b;
                a = b;
                b = c;
            }
            System.out.println(a2*b2/b);
        }
    }
}
