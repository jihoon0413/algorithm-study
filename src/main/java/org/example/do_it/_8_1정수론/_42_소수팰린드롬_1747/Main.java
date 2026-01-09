package org.example.do_it._8_1정수론._42_소수팰린드롬_1747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[10000001];

        check[1] = true;
        for(int i = 2 ; i <= Math.sqrt(10000000) ; i++) {
            if(check[i]) continue;
            for(int j = i+i ; j <= 10000000 ; j += i) {
                check[j] = true;
            }
        }

        for(int i = N ; i <= 10000000 ; i++) {
            if(!check[i]) {
                String str = String.valueOf(i);
                int len = str.length();
                boolean flag = true;
                if(len % 2 == 0) {
                    flag = true;
                    for(int j = 0; j < len/2 ; j++) {
                        if(str.charAt(j) != str.charAt(len-1-j)) {
                            flag = false;
                            break;
                        }
                    }
                } else {
                    flag = true;
                    for(int j = 0; j < len/2 + 1 ; j++) {
                        if(str.charAt(j) != str.charAt(len-1-j)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag) {
                    System.out.println(str);
                    break;
                }
            }
        }
    }
}
