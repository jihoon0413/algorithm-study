package org.example.백준.문자열.숫자의합_11720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt();
        String num = scan.next();
        int total = 0;

        for(int i = 0 ; i < count ; i++) {
            total += Integer.parseInt(String.valueOf(num.charAt(i)));   // 1.
//            total += num.charAt(i) - '0';     // 2. charAt() 은 아스키코드 값을 반환하므로 반드시 -48 또는 -'0' 을 해주어야 우리가 입력받은 숫자 값 그대로를 사용할 수 있음
//            total += num.charAt(i) - 48;      // 3.
        }
        System.out.println(total);
    }
}
