package org.example.do_it._4_3투포인터._8_좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * 4
 * 0 0 0 0 -> 이 예시 주의 깊게 살펴보기
 *
 * 10억 + 10억이 int를 넘어가서 long 사용??
 */

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < N ; i++) {
            long temp = arr[i];

            int s = 0;
            int g = N-1;

            while(s < g) {
                if(arr[s] + arr[g] < temp) {
                    s++;
                } else if (arr[s] + arr[g] > temp) {
                    g--;
                } else if(arr[s] + arr[g] == temp){

                    if(s != i && g != i) {
                        answer++;
                        break;
                    } else if(s == i) {
                        s++;
                    } else if(g == i) {
                        g--;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
