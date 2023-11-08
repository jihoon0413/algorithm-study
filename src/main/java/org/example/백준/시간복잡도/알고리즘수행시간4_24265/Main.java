package org.example.백준.시간복잡도.알고리즘수행시간4_24265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a = Long.parseLong(br.readLine());


        System.out.println(a*(a-1)/2);
        System.out.println(2);

    }
}
