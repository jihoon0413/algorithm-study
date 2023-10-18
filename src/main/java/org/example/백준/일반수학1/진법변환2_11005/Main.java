package org.example.백준.일반수학1.진법변환2_11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (a != 0) {

            if(a%b > 10) sb.append((char)((a%b) + 55));

            else sb.append(a%b);
            a /= b;
        }

        System.out.print(sb.reverse());
    }
}
