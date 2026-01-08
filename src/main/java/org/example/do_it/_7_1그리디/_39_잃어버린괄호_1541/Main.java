package org.example.do_it._7_1그리디._39_잃어버린괄호_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String str = br.readLine();

        String[] temp = str.split("-");

        int[] arr = new int[temp.length];
        int idx = 0;

        for(String s : temp) {
            String[] temp2 = s.split("\\+");
            int sum = 0;
            for(String s2 : temp2) {
                sum += Integer.parseInt(s2);
            }
            arr[idx++] = sum;
        }
        answer = arr[0];

        for(int i = 1; i < arr.length ; i++) {
            answer -= arr[i];
        }
        System.out.println(answer);
    }
}
