package org.example.백준.일반수학1.진법변환_2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int ans = 0;

        for(int i = 0 ; i < n.length() ; i++) {

            int temp = (int) Math.pow(b,i);
            int temp2 = n.charAt(n.length()-1-i);
            if(temp2 >= 65) {
                temp2 -= 55;
            } else {
                temp2 -= 48;
            }


            ans += temp * temp2;//n의 각수;

        }

        System.out.println(ans);


    }
}
