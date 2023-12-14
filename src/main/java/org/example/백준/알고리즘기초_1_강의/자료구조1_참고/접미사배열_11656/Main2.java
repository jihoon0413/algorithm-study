package org.example.백준.알고리즘기초_1_강의.자료구조1_참고.접미사배열_11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        String[] array = new String[st.length()];
        int length = st.length();

        for(int i = 0 ; i < st.length() ; i++) {
            array[i] = st.substring(i, length);
        }

        Arrays.sort(array);

        for(String temp : array) {
            System.out.println(temp);
        }

    }
}
