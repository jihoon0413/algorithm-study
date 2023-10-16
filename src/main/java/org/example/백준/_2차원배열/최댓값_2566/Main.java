package org.example.백준._2차원배열.최댓값_2566;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] array = new int[9][9];
        int max = 0;
        int row = 0, col = 0;

        for(int i = 0 ; i < 9 ; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < array[i].length; j++) {

                array[i][j] = scan.nextInt();
//                int n = Integer.parseInt(st.nextToken());

//                if(max < n) {
//                    max = n;
//                    row = i + 1;
//                    col = j + 1;
//                }
                if(max < array[i][j]) {
                    max = array[i][j];
                    row = i + 1;
                    col = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(row + " " + col);


    }
}
