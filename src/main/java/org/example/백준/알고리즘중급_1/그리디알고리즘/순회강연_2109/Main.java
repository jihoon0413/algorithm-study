package org.example.백준.알고리즘중급_1.그리디알고리즘.순회강연_2109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int day = 0;
        int[][] plan = new int[N][2];
        boolean[] deadLine;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            plan[i][0] = Integer.parseInt(st.nextToken());
            plan[i][1] = Integer.parseInt(st.nextToken());
            day = Math.max(day, plan[i][1]);
        }

        deadLine = new boolean[day+1];

        Arrays.sort(plan, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = plan[i][1]; j > 0 ; j--) {
                if(!deadLine[j]) {
                    deadLine[j] = true;
                    sum += plan[i][0];
                    break;
                }
            }
        }
        System.out.println(sum);

    }
}
