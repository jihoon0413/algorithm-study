package org.example.백준.기하_직사각형과삼각형.대지_9063;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] x = new int[count];
        int[] y = new int[count];

        StringTokenizer st;

        for(int i = 0 ; i < count ; i++) {
            st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findLength(x)*findLength(y));
        
    }

    static int findLength(int[] array) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int j : array) {

            if (j > max) max = j;
            if (j < min) min = j;

        }

        return max-min;

    }
}
