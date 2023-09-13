package org.example.백준.심화1.팰린드롬_10988;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String word = scan.next();
        boolean flag = true;

        for(int i = 0 ; i < word.length()/2 ; i++) {
            if(word.charAt(i) != word.charAt(word.length()-1-i)){
                flag = false;
                break;
            }
        }

        if(flag == true) {
            System.out.println("1");
        }else {
            System.out.println("0");
        }

    }
}
