package org.example.백준.알고리즘기초_2_강의.그래프.나이트의이동_7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[][] check;
    static boolean[] counts;
    static int x;
    static int y;
    static int I;
    static int ans;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int k = 0; k < n; k++) {

            I = Integer.parseInt(br.readLine());
            check = new boolean[I][I];
            counts = new boolean[I*I];
            ans = 0;

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());


            if(a != x || b != y) {
                bfs(a, b);
            }

            for(boolean temp : counts) {
                if(!temp) {
                    break;
                }
                ans++;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }


//    static void dfs(int a, int b, int count) {
//
//        if(count >= ans) {
//            return;
//        }
//
//        if(a == x && b == y) {
//            ans = count;
//            return;
//        }
//
//        for (int i = 0; i < 8; i++) {
//
//
//            int newX = a + dx[i];
//            int newY = b + dy[i];
//
//
//            if (newX < 0 || newX >= I || newY < 0 || newY >= I) {
//                continue;
//            }
//
//            if(!check[newX][newY]) {
//                check[newX][newY] = true;
//                dfs(newX, newY, count + 1);
//                check[newX][newY] = false;
//            }
//        }
//    }

    static void bfs(int a, int b) {

        Queue<int[]> que = new LinkedList<>();

        que.offer(new int[] {a, b, 0});
        int count = 0;

        while(!que.isEmpty()) {

            int[] temp = que.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            int tempCount = temp[2];

            for (int i = 0; i < 8; i++) {

                int newX = tempX + dx[i];
                int newY = tempY + dy[i];


                if (newX < 0 || newX >= I || newY < 0 || newY >= I) {
                    continue;
                }

                if(!check[newX][newY]) {
                    check[newX][newY] = true;
                    que.offer(new int[] {newX, newY, tempCount+1});
                    if(!counts[tempCount]) {
                        counts[tempCount] = true;
                        count++;
                    }
                }

                if(newX == x && newY == y) {
                    return;
                }
            }
        }
    }
}
