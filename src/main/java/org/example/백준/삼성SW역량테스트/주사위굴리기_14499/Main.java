package org.example.백준.삼성SW역량테스트.주사위굴리기_14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dx = {0,0,0,-1,1};
    static int[] dy = {0,1,-1,0,0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Dice dice = new Dice();
        for (int i = 0; i < K; i++) {
            int way = Integer.parseInt(st.nextToken());

            int newX = x + dx[way];
            int newY = y + dy[way];

            if(newX < 0 || newX >= N || newY < 0 || newY >= M) {
                continue;
            }

            if(way == 1) {
                dice.goEast();
            } else if(way ==2) {
                dice.goWest();
            } else if(way == 3) {
                dice.goNorth();
            } else {
                dice.goSouth();
            }


            x = newX;
            y = newY;
            int newNum = map[x][y];

            if(newNum == 0) {
                map[x][y] = dice.num[6];
            } else {
                dice.num[6] = newNum;
                map[x][y] = 0;
            }

            System.out.println(dice.getNum());

        }




    }

    static class Dice {

        int[] num = new int[7];

        public int getNum() {
            return num[1];
        }

        public void goEast() {
            int[] temp = num;
            num = new int[7];
            num[1] = temp[4];
            num[2] = temp[2];
            num[3] = temp[1];
            num[4] = temp[6];
            num[5] = temp[5];
            num[6] = temp[3];

        }

        public void goWest() {
            int[] temp = num;
            num = new int[7];
            num[1] = temp[3];
            num[2] = temp[2];
            num[3] = temp[6];
            num[4] = temp[1];
            num[5] = temp[5];
            num[6] = temp[4];
        }

        public void goNorth() {
            int[] temp = num;
            num = new int[7];
            num[1] = temp[5];
            num[2] = temp[1];
            num[3] = temp[3];
            num[4] = temp[4];
            num[5] = temp[6];
            num[6] = temp[2];
        }

        public void goSouth() {
            int[] temp = num;
            num = new int[7];
            num[1] = temp[2];
            num[2] = temp[6];
            num[3] = temp[3];
            num[4] = temp[4];
            num[5] = temp[1];
            num[6] = temp[5];
        }
    }
}
