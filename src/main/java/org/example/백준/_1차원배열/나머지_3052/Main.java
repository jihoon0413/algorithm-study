package org.example.백준._1차원배열.나머지_3052;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] num = new int[10];
        int[] rest = new int[10];
        int arrayCount;
        int count = 1;

        for (int i = 0; i < 10; i++) {
            num[i] = scan.nextInt();
            num[i] %= 42;
        }

        rest[0] = num[0];
        arrayCount = 1;

        for (int i = 1; i < 10; i++) {

            boolean flag = false;

            for (int j = 0; j < arrayCount; j++) {
                if (num[i] == rest[j]) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                count += 1;
                rest[arrayCount] = num[i];
                arrayCount += 1;
            }
        }
        System.out.println(count);
    }
}
