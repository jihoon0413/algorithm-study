package org.example.백준.알고리즘중급_1.BFS_연습.돌그룹_12886;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] temp = new int[3];

        temp[0] = a;
        temp[1] = b;
        temp[2] = c;

        Arrays.sort(temp);

        a = temp[0];
        b = temp[1];
        c = temp[2];

        boolean[][] check = new boolean[1501][1501];

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {a,b,c});

        int flag = 0;

        while(!que.isEmpty()) {

            int[] var = que.poll();

            if(var[0] == var[1] && var[1] ==var[2]) {
                flag = 1;
                break;
            }

            for (int i = 0; i < 3; i++) {

                a = var[i];
                b = var[(i+1)%3];
                c = var[(i+2)%3];

                if(a == b) {
                    continue;
                }

                if(a > b) {
                    a -= b;
                    b += b;
                } else {
                    b -= a;
                    a += a;
                }

                temp[0] = a;
                temp[1] = b;
                temp[2] = c;

                Arrays.sort(temp);

                a = temp[0];
                b = temp[1];
                c = temp[2];

                if(a > 0 && c <= 1000 && !check[a][b]) {
                    check[a][b] = true;
                    que.offer(new int[] {a,b,c});
                }
            }
        }
        System.out.println(flag);
    }
}