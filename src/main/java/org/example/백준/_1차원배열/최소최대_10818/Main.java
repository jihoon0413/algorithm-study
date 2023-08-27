package org.example.백준._1차원배열.최소최대_10818;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        int size;
        int max;
        int min;

        size = scan.nextInt();
        int[] numbers = new int[size];

        for(int i = 0 ; i < size ; i++ ) {
            numbers[i] = scan.nextInt();
        }

//        max = numbers[0];
//        min = numbers[0];
//        for(int i = 1 ; i < size ; i++ ) {
//            if(max < numbers[i]){
//                max = numbers[i];
//            }
//            if(min > numbers[i]){
//                min = numbers[i];
//            }
//        }
//        System.out.println(min + " " + max);

        Arrays.sort(numbers); //오름차순

        System.out.println(numbers[0] + " " + numbers[size-1]);

    }
}
