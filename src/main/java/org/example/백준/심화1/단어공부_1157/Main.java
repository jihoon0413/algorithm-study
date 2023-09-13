package org.example.백준.심화1.단어공부_1157;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] arr = new int[26];
        String word = scan.next();

        for(int i = 0 ; i < word.length() ; i++) {
            if( 65 <= word.charAt(i) && word.charAt(i) <= 90) {
                arr[word.charAt(i)-65]++;
            } else if (97 <= word.charAt(i) && word.charAt(i) <= 122) {
                arr[word.charAt(i)-97]++;
            }
        }

        int max = 0 ;
        char a = '?';

        boolean flag = false;

        for(int i = 0 ; i < 26 ; i++) {
            if(max < arr[i]) {
                max = arr[i];
                a = (char)(i + 65);
            } else if (max == arr[i]) {
                a = '?';
            }
        }

            System.out.println(a);


    }
}
