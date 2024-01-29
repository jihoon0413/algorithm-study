package org.example.백준.알고리즘기초_1_강의.수학1_연습.골드바흐파티션_17103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] prime = new boolean[1000001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        prime[0] = prime[1] = true;


        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = 2; i * j < prime.length; j++) {
                    prime[i * j] = true;
                }
            }
        }

        for( int i = 0 ; i < a ; i++ ){
            int num = Integer.parseInt(br.readLine());
            int count = 0;

            if(num % 2 == 0 && num != 0) {
                for (int j = 2; j <= num / 2; j++) {
                    if (!prime[j] && !prime[num - j]) {
                        count++;
                    }
                }
                sb.append(count).append("\n");
            } else {
                sb.append(0).append("\n");
            }


        }

        System.out.println(sb);
    }
}
