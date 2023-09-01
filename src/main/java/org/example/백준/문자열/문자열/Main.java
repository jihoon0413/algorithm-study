package org.example.백준.문자열.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String[] word = new String[num];

        for(int i = 0 ; i < num ; i++ ) {
            word[i] = br.readLine();
        }

        for(int i = 0 ; i < num ; i++ ) {
            int length = word[i].length();
            if (length == 1) {
                System.out.print(word[i].charAt(0));
                System.out.println(word[i].charAt(0));
            } else {
                System.out.print(word[i].charAt(0));
                System.out.println(word[i].charAt(length - 1));
            }
        }

    }
}
