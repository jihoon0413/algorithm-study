package org.example.백준.알고리즘중급_1.그리디알고리즘_연습.수묶기_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp > 0) {
                pos.add(temp);
            } else {
                neg.add(temp);
            }
        }

        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);


        int sum = getSum(pos, neg);
        System.out.println(sum);
    }

    private static int getSum(List<Integer> pos, List<Integer> neg) {
        int sum = 0;
        int i = 0;
        while (i < pos.size()) {
            if(i+1 < pos.size() && pos.get(i) != 1 && pos.get(i+1) != 1) {
                sum += (pos.get(i++)* pos.get(i++));
            } else {
                sum += pos.get(i++);
            }
        }

        i = 0;
        while (i < neg.size()) {
            if(i+1 < neg.size() && neg.get(i) != 1 && neg.get(i+1) != 1) {
                sum += (neg.get(i++)* neg.get(i++));
            } else {
                sum += neg.get(i++);
            }
        }
        return sum;
    }
}
