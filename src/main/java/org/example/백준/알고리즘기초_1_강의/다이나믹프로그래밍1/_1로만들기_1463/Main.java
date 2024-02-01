package org.example.백준.알고리즘기초_1_강의.다이나믹프로그래밍1._1로만들기_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] array;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        array = new Integer[a+1];

        array[0] = array[1] = 0;

        System.out.println(getCount(a));
    }

    static int getCount(int a) {

        if(array[a] == null) {
            if (a % 6 == 0) {
                array[a] = Math.min(getCount(a/3), Math.min(getCount(a/2), getCount(a-1))) + 1;
            } else if (a % 3 == 0) {
                array[a] = Math.min(getCount(a/3), getCount(a-1)) + 1;
            } else if (a % 2 == 0) {
                array[a] = Math.min(getCount(a/2), getCount(a-1)) + 1;
            } else {
                array[a] = getCount(a-1) + 1;
            }
        }

        return array[a];

    }

}
