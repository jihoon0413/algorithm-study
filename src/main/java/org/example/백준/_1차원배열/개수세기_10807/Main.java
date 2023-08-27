package org.example.백준._1차원배열.개수세기_10807;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int input;
        int toFind;
        int count = 0;


        input = scan.nextInt();

        int[] numbers = new int[input];

        for(int i = 0; i < input; i++) {

            numbers[i] = scan.nextInt();

        }


        toFind = scan.nextInt();

        for(int i = 0; i < input; i++) {
            if(numbers[i] == toFind){
                count++;
            }
        }
        System.out.print(count);



    }
}
