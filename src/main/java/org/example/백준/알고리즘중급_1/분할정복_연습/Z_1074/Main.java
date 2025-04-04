package org.example.백준.알고리즘중급_1.분할정복_연습.Z_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        findZ(0, 0, size);
    }

    static void findZ(int a, int b , int size) {

        if(size == 1) {
            System.out.println(count);
            return;
        }

        int newSize = size/2;

        if(r < a + newSize && c < b + newSize){
            findZ(a,b,newSize);

        }

        if(r < a + newSize && c >= b + newSize){
            count += newSize*newSize;
            findZ(a, b+newSize, newSize);
        }

        if(r >= a + newSize && c < b + newSize){
            count += newSize*newSize*2;
            findZ(a+newSize, b, newSize);
        }

        if(r >= a + newSize && c >= b + newSize){
            count += newSize*newSize*3;
            findZ(a+newSize, b+newSize, newSize);
        }
    }
}
