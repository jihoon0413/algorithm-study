package org.example.백준.심화1.별찍기_2444;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int layer;

        layer = scan.nextInt();

        for(int i = 0 ; i < layer*2-1 ; i++) {
            if(i >= layer){
                int spare = i - layer + 1;
                int count = (layer - (spare)) * 2 - 1;
                for(int j = 0 ; j < spare ; j++) {
                    System.out.print(" ");
                }
                for(int j = 0 ; j < count; j++) {
                    System.out.print("*");
                }
                System.out.println();

            }
            else {
                int spare = layer - (i + 1);
                int count = (i + 1) * 2 - 1;

                for (int j = 0; j < spare; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < count; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
