package org.example.백준.알고리즘기초_1.자료구조1_참고.접미사배열_11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        String[] array = new String[st.length()];
        ArrayList<Character> arrayList = new ArrayList<>();

        for(int i = 0 ; i < st.length() ; i++) {
            arrayList.add(st.charAt(i));
        }

        for(int i = 0 ; i < st.length() ; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = i ; j < st.length() ; j++) {
                sb.append(arrayList.get(j));
            }

            array[i] = String.valueOf(sb);
        }

        Arrays.sort(array);

        for(int i = 0 ; i < st.length() ; i++) {
            System.out.println(array[i]);
        }
    }
}
