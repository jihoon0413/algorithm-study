package org.example.백준.자료구조1.단어뒤집기_9093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int wordCount = st.countTokens();
            StringBuilder answer = new StringBuilder();

            for(int j = 0 ; j < wordCount ; j++) {

                StringBuilder word = new StringBuilder(st.nextToken());

                    answer.append(word.reverse()).append(" ");
            }
            System.out.println(answer);
        }
    }
}
