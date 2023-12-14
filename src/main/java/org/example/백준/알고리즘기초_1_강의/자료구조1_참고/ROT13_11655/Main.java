package org.example.백준.알고리즘기초_1_강의.자료구조1_참고.ROT13_11655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String st = br.readLine();

        for(int i = 0 ; i < st.length() ; i++) {

            char ch = st.charAt(i);

            if(Character.isUpperCase(ch)) {
                if(Character.isUpperCase(ch + 13)) {
                    ch += 13;
                    sb.append(ch);
                } else {
                    ch -= 13;
                    sb.append(ch);
                }
            } else if(Character.isLowerCase(ch)) {
                if(Character.isLowerCase(ch + 13)) {
                    ch += 13;
                    sb.append(ch);
                } else {
                    ch -= 13;
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }


        }

        System.out.println(sb);

    }
}
