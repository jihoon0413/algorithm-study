package org.example.백준.기하_직사각형과삼각형.삼각형과세변_5073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            int[] length = new int[3];
            int index = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0 ; i < 3 ; i++) {
                int max =0;
                length[i] = Integer.parseInt(st.nextToken());

                if(max < length[i]) {
                    max = length[i];
                    index = i;
                }
            }

            if(length[0] == 0 &&length[1] == 0 && length[2] == 0) {
                break;
            }

            if(checkLength(length, index)) {
                if(length[0] == length[1] && length[1] == length[2]) {
                    System.out.println("Equilateral");
                } else if (length[0] == length[1] || length[1] == length[2] || length[0] == length[2]) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }

            } else {
                System.out.println("Invalid");
            }


//            Arrays.sort(length);
//
//            if(length[2] >= length[0] + length[1]) {
//                System.out.println("Invalid");
//            }else if(length[0] == length[1] && length[1] == length[2]) {
//                System.out.println("Equilateral");
//            }else if(length[0] == length[1] || length[1] == length[2] || length[0] == length[2]) {
//                System.out.println("Isosceles");
//            }else {
//                System.out.println("Scalene");
//            }


//            ====================>  정렬을 통해 문제를 푼다면 아래의 checkLength 메소드가 필요하지 않음...더 간단하게 할 수 있었음.....

        }

    }

    static boolean checkLength(int[] array, int index) {

        if(index == 0 ) {
            return array[0] < array[1] + array[2];
        } else if (index == 1 ) {
            return array[1] < array[0] + array[2];
        } else if (index == 2 ) {
            return array[2] < array[0] + array[1];
        } else return false;
    }


}
