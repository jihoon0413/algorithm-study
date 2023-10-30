package org.example.백준.기하_직사각형과삼각형.네번째점_3009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] x = new int[3];
        int[] y = new int[3];
        int a;
        int b;

        StringTokenizer sb;

        for(int i = 0 ; i < 3 ; i++) {
            sb = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(sb.nextToken());
            y[i] = Integer.parseInt(sb.nextToken());
        }

//        if(x[0] != x[1]) {
//            if(x[0] != x[2]){
//                a = x[0];
//            } else {
//                a = x[1];
//            }
//        }
//        else {
//            a = x[2];
//        }
//
//        if(y[0] != y[1]) {
//            if(y[0] != y[2]){
//                b = y[0];
//            } else {
//                b = y[1];
//            }
//        }
//        else {
//            b = y[2];
//        }

//        System.out.println(a + " " + b);

        System.out.println(findDot(x) + " " + findDot(y));
    }

    public static int findDot(int[] array) {

        if(array[0] != array[1]) {
            return (array[0] != array[2]) ?  array[0] : array[1];
        }
        else {
            return array[2];
        }

    }

}
