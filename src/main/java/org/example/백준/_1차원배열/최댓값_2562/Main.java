package org.example.백준._1차원배열.최댓값_2562;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = new int[9];
        int max;
        int count = 1;

        for(int i = 0 ; i < numbers.length ; i++ ) {
            numbers[i] = scan.nextInt();
        }
        max = numbers[0];

        for(int i = 1 ; i < numbers.length ; i++ ) {

            if(max < numbers[i]) {
                max = numbers[i];
                count = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(count);
    }
}
