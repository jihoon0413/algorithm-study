package org.example.백준.코딩테스트준비_문제_강의.차량번호판1_16968;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String form = br.readLine();

        int count = form.length();

        final int word = 26;
        final int num = 10;
        boolean front = true;
        int ans = 1;

        for(int i = 0 ; i < count ; i++) {

            switch (form.charAt(i)) {

                case 'c':
                    if(i >= 1 && form.charAt(i-1) == 'c') {
                        ans *= word -1;
                        break;
                    }
                    ans *= word;
                    break;
                case 'd':
                    if(i >= 1 && form.charAt(i-1) == 'd') {
                        ans *= num -1;
                        break;
                    }
                    ans *= num;
                    break;
            }
        }
        System.out.println(ans);

    }
}
