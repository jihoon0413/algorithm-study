package org.example.백준.알고리즘기초_1.자료구조1_참고.문자열분석_10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a;

        while ((a = br.readLine()) != null) {
            int upper = 0;
            int lower = 0;
            int space = 0;
            int num = 0;

            for (int i = 0; i < a.length(); i++) {

                char ch = a.charAt(i);

                if ('A' <= ch && ch <= 'Z') {
                    upper++;
                } else if ('a' <= ch && ch <= 'z') {
                    lower++;
                } else if (ch == ' ') {
                    space++;
                } else if ('0' <= ch && ch <= '9') {
                    num++;
                }
            }

            System.out.println(lower + " " + upper + " " + num + " " + space);
        }
    }
}
