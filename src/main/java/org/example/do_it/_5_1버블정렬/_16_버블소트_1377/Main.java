package org.example.do_it._5_1버블정렬._16_버블소트_1377;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;

        int N = Integer.parseInt(br.readLine());

        List<Data> list = new ArrayList<>();

        for(int i = 0 ; i < N ; i++) {
            list.add(new Data(i, Integer.parseInt(br.readLine())));
        }

        list.sort((o1, o2) -> {
            return o1.value - o2.value;
        });

        int[] ans = new int[N];
        for(int i = 0 ; i < N ; i++) {
            ans[i] = list.get(i).index - i;
        }

        Arrays.sort(ans);

        answer = ans[N-1] + 1;

        System.out.println(answer);

    }

    static class Data{
        int index;
        int value;

        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
