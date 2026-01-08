package org.example.do_it._7_1그리디._37_수묶기_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> posQue = new PriorityQueue<>((o1,o2) -> {return o2 - o1;});
        PriorityQueue<Integer> negQue = new PriorityQueue<>();
        int zeroCnt = 0;

        for(int i = 0 ; i < N ; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a > 1) {
                posQue.add(a);
            } else if(a == 1) {
                answer++;
            } else if (a < 0) {
                negQue.add(a);
            } else {
                zeroCnt++;
            }
        }

        while(posQue.size() > 1) {
            int a = posQue.poll();
            int b = posQue.poll();

            answer += a*b;
        }

        while(!posQue.isEmpty()) {
            answer += posQue.poll();
        }


        while(negQue.size() > 1) {
            int a = negQue.poll();
            int b = negQue.poll();

            answer += (a*b);
        }


        while(!negQue.isEmpty()) {
            if(zeroCnt != 0) {
                zeroCnt--;
                negQue.poll();
            }
            if(negQue.size() > 0) {
                answer += negQue.poll();
            }
        }


        System.out.println(answer);

    }
}
