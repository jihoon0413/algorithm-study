package org.example.백준.심화1.그룹단어체커_1316;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        String[] word = new String[num];
        int count = 0;

        for (int i = 0; i < num; i++) {

            word[i] = scan.next();

            if(check(word[i])){
                count++;
            };
        }

        System.out.println(count);


    }


    public static boolean check(String word) {
        boolean[] alpha = new boolean[26];
        char now = 0;

        for (int j = 0; j < word.length(); j++) {

            if (now != word.charAt(j)) {
                now = word.charAt(j);

                if (alpha[now - 'a'] == false) {
                    alpha[now - 'a'] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


}




