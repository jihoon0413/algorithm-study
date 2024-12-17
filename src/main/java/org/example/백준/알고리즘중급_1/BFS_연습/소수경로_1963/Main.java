package org.example.백준.알고리즘중급_1.BFS_연습.소수경로_1963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] prime = new boolean[10000];
    public static void main(String[] args) throws IOException {

        prime[0] = prime[1] = true;

        for (int i = 2; i < 10000; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < 10000; j += i) {
                    prime[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int k = 0; k < n; k++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int goal = Integer.parseInt(st.nextToken());

            boolean[] visit = new boolean[10000];
            int ans = Integer.MAX_VALUE;

            Queue<int[]> que = new LinkedList<>();

            que.add(new int[] {start, 0});
            visit[start] = true;

            while (!que.isEmpty()) {

                int[] q = que.poll();
                int num = q[0];
                int count = q[1];

                if(num == goal) {
                    ans = count;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j <= 9; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int newNum = change(num,i,j);
                        if(!prime[newNum] && !visit[newNum]) {
                            visit[newNum] = true;
                            que.offer(new int[] {newNum, count+1});
                        }
                    }
                }
            }

            sb.append(ans);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static int change(int num, int i, int j) {

        StringBuilder str = new StringBuilder(String.valueOf(num));

        str.setCharAt(i, (char)(j +'0'));
        return Integer.parseInt(str.toString());
    }
}
