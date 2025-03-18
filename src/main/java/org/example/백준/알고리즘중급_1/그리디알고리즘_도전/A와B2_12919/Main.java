package org.example.백준.알고리즘중급_1.그리디알고리즘_도전.A와B2_12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static String T;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(T);
        if(flag) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }

    public static void dfs(String str) {

        if(str.equals(S)) {
            flag = true;
            return;
        }

        if(str.length() <= S.length()) {
            return;
        }

        if(str.charAt(0) == 'B') {
            dfs(reverseString(str));
        }

        if(str.charAt(str.length()-1) == 'A') {
            dfs(deleteLastChar(str));
        }
    }

    public static String reverseString(String str) {

        StringBuilder sb = new StringBuilder(str);
        return deleteLastChar(sb.reverse().toString());
    }

    public static String deleteLastChar(String str) {
        return str.substring(0, str.length()-1);
    }
}
