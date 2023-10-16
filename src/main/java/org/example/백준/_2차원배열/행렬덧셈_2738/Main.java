package org.example.백준._2차원배열.행렬덧셈_2738;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int row = scan.nextInt();
        int col = scan.nextInt();

        int[][] a = new int[row][col];
        int[][] b = new int[row][col];
        int[][] c = new int[row][col];

        for(int i = 0 ; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = scan.nextInt();
            }
        }

        for(int i = 0 ; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                b[i][j] = scan.nextInt();
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        for(int i = 0 ; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

    }
}
