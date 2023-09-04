package org.example.백준.문자열.문자열반복_2675;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int p = scan.nextInt();

        for (int i = 0 ; i < p ; i++) {

            int count = scan.nextInt();
            String word = scan.next();

            for(int j = 0 ; j < word.length() ; j++) {
                for (int k = 0 ; k < count ; k++) {
                    System.out.print(word.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
