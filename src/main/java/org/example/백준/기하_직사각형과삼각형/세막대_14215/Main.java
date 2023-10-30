package org.example.백준.기하_직사각형과삼각형.세막대_14215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] length = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 3 ; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(length);

        if(length[2] >= length[0] + length[1]) {
            length[2] = length[0] + length[1] - 1;
        }

        System.out.println(length[0] + length[1] + length[2]);

    }
}
