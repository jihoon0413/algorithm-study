package org.example.백준.자료구조1.괄호_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++ ) {

            String vps = br.readLine();
            System.out.println(check(vps));

        }
    }

    static String check(String vps) {

        Stack<Character> stack = new Stack<>();


        for(int j = 0 ; j < vps.length() ; j++) {
            if(vps.charAt(j) == '(') {
                stack.push('(');
            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        if(stack.empty()) {
            return "YES";
        }else{
            return "NO";
        }
    }
}
