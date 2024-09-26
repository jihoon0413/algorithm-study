package org.example.백준.알고리즘중급_1.BFS_연습.뱀과사다리게임_16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]> stair = new ArrayList<>();
    static boolean[] check = new boolean[101];
    static int total;
    static int ans = 100;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        total = N + M;
        for (int i = 0; i < total; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            stair.add(new int[] {temp1, temp2});
        }

        solve();
        System.out.println(ans);
    }
    static void solve() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {1,0}); // 위치, 횟수
        check[1] = true;

        while (true) {

            int[] info = que.poll();
            int loc = info[0];
            int count = info[1];

            if(loc == 100) {
                ans = Math.min(ans, count);
                return;
            }

            if(count > ans) {
                return;
            }

            for (int i = 1; i <= 6; i++) {

                int next = loc + i;

                if(next <= 100 && !check[next]) {
                    int stair = checkStair(next);
                    check[next] = true;
                    if(stair != 0) {
                        if(stair <= 100) {
                            next = stair;
                        }
                    }
                    que.offer(new int[] {next, count+1});
                }
            }
        }
    }

    static int checkStair(int nowLoc) {
        int newLoc = 0;

        for (int i = 0; i < total; i++) {
            if(stair.get(i)[0] == nowLoc) {
                newLoc = stair.get(i)[1];
                break;
            }
        }
        return newLoc;
    }
}
