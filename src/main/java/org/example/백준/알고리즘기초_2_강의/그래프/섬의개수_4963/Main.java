package org.example.백준.알고리즘기초_2_강의.그래프.섬의개수_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        boolean[][] arr;

        while (w != 0 && h != 0) {

            arr = new boolean[h][w];
            int count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    if(Integer.parseInt(st.nextToken())==1) {
                        arr[i][j] = true;
                    } else {
                        arr[i][j] = false;
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(arr[i][j]) {
                        arr[i][j] = false;
                        solve(arr, i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);


    }
    static void solve(boolean[][] arr, int a, int b) {

        int h = arr.length;
        int w = arr[0].length;

        int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {a,b});

        while (!queue.isEmpty()) {

            int[] temp = queue.poll();

            int x = temp[0];
            int y = temp[1];

            for(int i = 0 ; i < 8 ; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(newX < 0 || newX >= h || newY < 0 || newY >= w) {
                    continue;
                }
                if(arr[newX][newY]) {
                    queue.offer(new int[] {newX,newY});
                    arr[newX][newY] = false;
                }
            }
        }
    }
}
