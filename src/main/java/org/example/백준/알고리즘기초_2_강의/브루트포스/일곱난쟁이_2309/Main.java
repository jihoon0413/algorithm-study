package org.example.백준.알고리즘기초_2_강의.브루트포스.일곱난쟁이_2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int temp = 0;
        for(int i = 0 ; i < 9 ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            temp += arr[i];
        }

        temp -= 100;

        for(int i = 0 ; i < 8 ; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (arr[i] + arr[j] == temp) {
                    arr[i] = 100;
                    arr[j] = 100;
                    Arrays.sort(arr);

                    for(int k = 0 ; k < 7 ; k++) {
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }


    }
}
