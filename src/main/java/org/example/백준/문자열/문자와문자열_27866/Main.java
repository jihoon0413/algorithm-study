package org.example.백준.문자열.문자와문자열_27866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        String input = scan.next();
        int num = scan.nextInt();

        System.out.println(input.charAt(num-1));

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String st = br.readLine();
//        int n = Integer.parseInt(br.readLine())-1;
//
//        br.close();
//
//        System.out.println(st.charAt(n));



    }
}
