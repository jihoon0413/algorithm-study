package org.example.백준.브루트포스.수학은비대면강의입니다_19532;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());


//        int y = (c*d - a*f) / (b*d - a*e);
//        int x = (c*e - b*f) / (a*e - b*d);
//
//        System.out.println(x + " " + y);

        // 알고리즘음 위에가 더 효율적인 것 같지만 브루트 포스 방법으로 푸는 거라면 아래 식이 맞는거 같음


        for(int i = -999 ; i <= 999 ; i++) {
            for(int j = -999 ; j <=999 ; j++) {
                if(a*i + b*j == c && d*i + e*j == f) {
                    System.out.println(i + " " + j);
                    break;
                }

            }

        }


    }
}
