package org.example.백준._1차원배열.과제안내신분_5597;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] students = new int[30];
        int[] submit = new int[28];
        int[] notSubmit = new int[2];
        int num =0;


        for(int i = 0 ; i < 30 ; i++) {
            students[i] = i + 1;
        }

        for(int i = 0 ; i < 28 ; i++) {
            submit[i] = scan.nextInt();
        }

        for(int i = 0 ; i < 30 ; i++) {

            boolean flag = false;

            for(int j = 0 ; j < 28 ; j++) {
                if (students[i] == submit[j]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                notSubmit[num] = students[i];
                num++;
            }
        }

        Arrays.sort(notSubmit);

        for(int i = 0 ; i < notSubmit.length ; i++) {
            System.out.println(notSubmit[i]);
        }

    }
}
