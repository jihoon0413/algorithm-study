package org.example.백준.알고리즘기초_1_강의.수학1.팩토리얼_10872;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int ans = 1;

        for(int i = 1 ; i <= a ; i++) {
            ans *= i;
        }

        System.out.println(ans);

    }
}
