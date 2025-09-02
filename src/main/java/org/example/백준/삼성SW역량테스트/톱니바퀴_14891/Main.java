package org.example.백준.삼성SW역량테스트.톱니바퀴_14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] gears;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new boolean[4][8];

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                if(str.charAt(j) == '1') {
                    gears[i][j] = true;
                }
            }
        }

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken())-1;
            int way = Integer.parseInt(st.nextToken());

            check(gearNum, way);
        }

        int ans = getScore();
        System.out.println(ans);
    }

    public static int getScore() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i][0]) {
                score += (int) Math.pow(2,i);
            }
        }
        return score;
    }

    public static void check(int gearNum, int way) {
        boolean temp = gears[gearNum][2];
        int tempWay = way;

        for (int i = gearNum+1; i < 4; i++) {
            if(temp != gears[i][6]) {
                temp = gears[i][2];
                tempWay *= -1;
                turn(i, tempWay);
            } else {
                break;
            }
        }

        temp = gears[gearNum][6];
        tempWay = way;
        for (int i = gearNum-1; i >= 0 ; i--) {
            if(temp != gears[i][2]) {
                temp = gears[i][6];
                tempWay *= -1;
                turn(i, tempWay);
            } else {
                break;
            }
        }
        turn(gearNum, way);
    }


    public static void turn(int gearNum, int way) {

        if(way == 1) {
            boolean temp = gears[gearNum][7];
            for (int i = 7; i > 0 ; i--) {
                gears[gearNum][i] = gears[gearNum][i-1];
            }
            gears[gearNum][0] = temp;
        } else {
            boolean temp = gears[gearNum][0];
            for (int i = 0; i < 7; i++) {
                gears[gearNum][i] = gears[gearNum][i+1];
            }
            gears[gearNum][7] = temp;
        }
    }
}
