package org.example.백준.알고리즘중급_1.그리디알고리즘.보석도둑_1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[][] treasure;
    static int[] capacity;
    static boolean[] checkBag;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        treasure = new int[N][2];
        capacity = new int[K];
        checkBag = new boolean[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            treasure[i][0] = Integer.parseInt(st.nextToken());
            treasure[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            capacity[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(treasure, (a,b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0],b[0]);
            } else {
                return Integer.compare(b[1],a[1]);
            }
        });

        Arrays.sort(capacity);



        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long ans = 0;
        for (int i = 0, j=0; i < K; i++) {

            while (j < N && treasure[j][0] <= capacity[i]) {
                pq.offer(treasure[j++][1]);
            }

            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }
}
