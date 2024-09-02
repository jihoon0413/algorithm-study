package org.example.백준.알고리즘중급_1.브루트포스_재귀_연습.스도미노쿠_4574;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] rowCheck;
    static boolean[][] colCheck;
    static boolean[][] blockCheck;
    static boolean[][] numSet;
    static boolean complete;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if(N == 0) {
                break;
            }

            arr = new int[9][9];
            rowCheck = new boolean[9][10];
            colCheck = new boolean[9][10];
            blockCheck = new boolean[9][10];
            numSet = new boolean[10][10];
            complete = false;

            for (int i = 1; i <= 9; i++) {
                numSet[i][i] = true;
            }

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int[] set = new int[2];
                for (int j = 0; j < 2; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    set[j] = value;
                    String loc = st.nextToken();
                    int x = loc.charAt(0) - 'A';
                    int y = loc.charAt(1) - '1';
                    int block = getBlockNum(x,y);
                    doSudoku(x,y,block, value);
                }
                numSet[set[0]][set[1]] = numSet[set[1]][set[0]] = true;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 9; i++) {
                String loc = st.nextToken();
                int x = loc.charAt(0) - 'A';
                int y = loc.charAt(1) - '1';
                int block = getBlockNum(x, y);
                doSudoku(x, y, block, i);
            }


            System.out.println("Puzzle " + num);

            dfs(0,0);

            num++;

        }

    }
    static void dfs(int x, int y) {
        if(y == 9) {
            dfs(x+1,0);
            return;
        }

        if(complete) {
            return;
        }

        if(x == 9) {
            complete = true;
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(arr[i][j]);
                    }
                    sb.append("\n");
                }

                System.out.print(sb);
                return;

        }

        if(arr[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                int blockNum = getBlockNum(x,y);
                if(check(x,y,blockNum,i)) {
                    doSudoku(x,y,blockNum,i);
                    for (int j = 0; j < 2; j++) {
                        int tempX = x + dx[j];
                        int tempY = y + dy[j];

                        if(tempX < 0 || tempX >= 9 || tempY < 0 || tempY >= 9 || arr[tempX][tempY] != 0) {
                            continue;
                        }

                        int tempBlock = getBlockNum(tempX,tempY);
                        for (int k = 1; k < 10; k++) {
                            if(check(tempX,tempY,tempBlock,k) && !numSet[i][k]) {

                                doSudoku(tempX, tempY, tempBlock, k);
                                numSet[i][k] = numSet[k][i] = true;
                                dfs(x,y+1);
                                undoSudoku(tempX, tempY, tempBlock, k);
                                numSet[i][k] = numSet[k][i] = false;
                            }
                        }

                    }
                    undoSudoku(x,y,blockNum,i);
                }
            }
            arr[x][y] = 0;
            return;
        }

        dfs(x,y+1);


    }
    static boolean check(int x, int y , int block, int value) {
        if(rowCheck[x][value] || colCheck[y][value] || blockCheck[block][value]) {
            return false;
        }
        return true;
    }
    static int getBlockNum(int x, int y) {
        return (y/3)*3 + (x/3);
    }
    static void doSudoku(int x, int y , int block, int value) {
        arr[x][y] = value;
        rowCheck[x][value] = true;
        colCheck[y][value] = true;
        blockCheck[block][value] = true;
    }

    static void undoSudoku(int x, int y , int block, int value)  {
        arr[x][y] = 0;
        rowCheck[x][value] = false;
        colCheck[y][value] = false;
        blockCheck[block][value] = false;
    }
}
