package org.example.백준._1차원배열.X보다작은수_10871;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);

        int length;
        int compare;

        length = scan.nextInt();
        compare = scan.nextInt();
        int[] numbers = new int[length];

        for(int i = 0 ; i < length ; i++) {
            numbers[i] = scan.nextInt();
        }

        for (int i = 0 ; i < length ; i++) {
            if(numbers[i] < compare) {
                System.out.print(numbers[i] + " ");
            }
        }
    }
}
