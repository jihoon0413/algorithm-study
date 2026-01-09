package org.example.do_it._8_1정수론._41_거의소수_1456;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        boolean[] check = new boolean[10000001]; // 최대 10^14까지 올 수 있는데 감장이 안되니까 10^7으로만 크기를 제한

        check[1] = true;
        for(int i = 2; i <= 10000000 ; i++) {
            if(check[i]) continue;
            for(int j = i + i ; j <= 10000000 ; j+=i) { //여기에 범위를 M으로 해버리면 M이 최대 값의 제곱근인 10,000,000를 넘길 수 있음
                check[j] = true;
            }
        }

        for(int i = 2 ; i <= 10000000 ; i++) {
            if(!check[i]) {
                long temp = i;
                while((double)i <= (double) M/(double)temp) { // long범위를 넘어갈 수 있기 때문에 temp * i < M -> i < M/temp
                    if((double) N/(double)temp <= (double)i) {
                        answer++;
                    }
                    temp *= i;
                }
            }
        }

        System.out.println(answer);
    }
}

