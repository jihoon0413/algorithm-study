package org.example.백준.알고리즘기초_1.자료구조1_참고.네수_10824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long a = Long.parseLong(st.nextToken() + st.nextToken());
        long b = Long.parseLong(st.nextToken() + st.nextToken());

        System.out.println(a+b);

    }
}
