package org.example.백준.알고리즘기초_2_강의.그래프1_도전.다리만들기_2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans;
    static List<int[]> lists;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int idx = 1;
        lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j] && arr[i][j] != 0) {
                    islandCount(i, j, idx);
                    idx++;
                }
            }
        }

        ans = Integer.MAX_VALUE;

        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!check[i][j] && arr[i][j] != 0) {
                    bridge(i,j,arr[i][j]);
                }
            }
        }

        System.out.println(ans);

    }

    static void islandCount(int a, int b, int idx) {

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{a, b});
        arr[a][b] = idx;

        while (!que.isEmpty()) {

            int[] temp = que.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
                    continue;
                }

                if (!check[newX][newY] && arr[newX][newY] != 0) {
                    check[newX][newY] = true;
                    arr[newX][newY] = idx;
                    que.offer(new int[] {newX, newY});
                }
            }
        }
    }

    static void bridge(int a, int b, int idx) {

        check[a][b] = true;

        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(a,b,0));


        boolean[][] isVisited = new boolean[N][N];
        isVisited[a][b] = true;

        while(!que.isEmpty()){
            Node temp = que.poll();

            for(int i = 0; i<4; i++){
                int newX = temp.x + dx[i];
                int newY = temp.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= N)
                    continue;
                if(arr[newX][newY] == idx) {
                    check[newX][newY] = true;
                    continue;
                }
                if(isVisited[newX][newY])
                    continue;

                if(arr[newX][newY] == 0) {
                    que.offer(new Node(newX, newY, temp.length+1));
                    isVisited[newX][newY] = true;
                }
                else if(arr[newX][newY] != idx){
                    ans = Math.min(ans, temp.length);
                    return;
                }
            }
        }
    }

    static class Node {
        int x, y, length;

        Node(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
