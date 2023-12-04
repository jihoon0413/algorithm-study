package org.example.백준.알고리즘기초_1_강의.자료구조1.괄호_9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        for (int i = 0; i < a; i++) {
            String vps = br.readLine();
            int count = vps.length();
            boolean ans = true;
            int open = 0;
            int close = 0;

            if (count % 2 == 0) {
                for (int j = 0; j < count; j++) {
                    if (vps.charAt(j) == '(') {
                        open++;
                        ans = false;
                    } else if (vps.charAt(j) == ')') {

                        close++;

                        if (open < close) {
                            ans = false;
                            break;
                        }

                        if (open == close) {
                            ans = true;
                        }
                    }

                }
                if (open == close && close == count / 2 && ans) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}


