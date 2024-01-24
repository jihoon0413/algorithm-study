package org.example.백준.알고리즘기초_1_강의.수학1_연습._2진수8진수_1373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String two = br.readLine();

        int index = two.length()-1;
        Stack<Integer> ans = new Stack<>();

        while (index != -1) {
            int a = 0;
            for(int i = 0 ; i < 3 ; i++) {
                a += Math.pow(2,i) * Integer.parseInt(String.valueOf(two.charAt(index)));
                index -= 1;
                if(index == 0 ) {
                    break;
                }

            }
            ans.push(a);
        }

        StringBuilder sb = new StringBuilder();

        while (!ans.isEmpty()) {
            sb.append(ans.pop());
        }

        System.out.println(sb);

    }
}
