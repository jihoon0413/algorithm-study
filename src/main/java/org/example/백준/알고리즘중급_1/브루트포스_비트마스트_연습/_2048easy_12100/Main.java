package org.example.백준.알고리즘중급_1.브루트포스_비트마스트_연습._2048easy_12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static boolean[][] check;
    static int N;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int max = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }

        System.out.println(max);

    }
    static void solve(int count) {

        if(count == 5 ) {
            findMax();
            return;
        }

        int[][] copy = new int[N][N];

        for (int i = 0; i < N; i++) {
            copy[i] = board[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            check = new boolean[N][N];
            move(dx[i],dy[i]);
            solve(count+1);
            for (int j = 0; j < N; j++) {
                board[j] = copy[j].clone();
            }
        }

    }
    static void move(int x, int y) {

        if(x == 0 ) {
            if( y == 1) {
                for (int i = 0; i < N; i++) {
                    for (int j = N-2; j >= 0; j--) {
                        int newY = j;

                        if(board[i][j] == 0 || check[i][j]) {
                            continue;
                        }

                        while(true) {
                            newY += 1;
                            if(newY == N) {
                                break;
                            }
                            if(board[i][newY] == 0) {
                                board[i][newY] = board[i][newY-1];
                                board[i][newY-1] = 0;
                            } else if( board[i][newY] == board[i][newY-1] && !check[i][newY] && !check[i][newY-1]) {
                                board[i][newY] += board[i][newY-1];
                                check[i][newY] = true;
                                board[i][newY-1] = 0;
                            }

                        }

                    }
                }
            } else {
                for (int i = 0; i < N; i++) {
                    for (int j = 1; j < N; j++) {
                        int newY = j;

                        if(board[i][j] == 0 || check[i][j]) {
                            continue;
                        }

                        while(true) {
                            newY -= 1;
                            if(newY == -1) {
                                break;
                            }
                            if(board[i][newY] == 0) {
                                board[i][newY] = board[i][newY+1];
                                board[i][newY+1] = 0;
                            } else if( board[i][newY] == board[i][newY+1] && !check[i][newY] && !check[i][newY+1]) {
                                board[i][newY] += board[i][newY+1];
                                check[i][newY] = true;
                                board[i][newY+1] = 0;
                            }

                        }

                    }

                }
            }
        } else {
            if( x == 1) {
                for (int i = 0; i < N; i++) {
                    for (int j = N-2; j >= 0; j--) {
                        int newX = j;

                        if(board[j][i] == 0 || check[j][i]) {
                            continue;
                        }

                        while(true) {
                            newX += 1;
                            if(newX == N) {
                                break;
                            }
                            if(board[newX][i] == 0) {
                                board[newX][i] = board[newX-1][i];
                                board[newX-1][i] = 0;
                            } else if( board[newX][i] == board[newX-1][i] && !check[newX][i] && !check[newX-1][i]) {
                                board[newX][i] += board[newX-1][i];
                                check[newX][i] = true;
                                board[newX-1][i] = 0;
                            }

                        }

                    }

                }
            } else {
                for (int i = 0; i < N; i++) {
                    for (int j = 1; j < N; j++) {
                        int newX = j;

                        if(board[j][i] == 0 || check[j][i]) {
                            continue;
                        }

                        while(true) {
                            newX -= 1;
                            if(newX == -1) {
                                break;
                            }
                            if(board[newX][i] == 0) {
                                board[newX][i] = board[newX+1][i];
                                board[newX+1][i] = 0;
                            } else if( board[newX][i] == board[newX+1][i] && !check[newX][i] && !check[newX+1][i]) {
                                board[newX][i] += board[newX+1][i];
                                check[newX][i] = true;
                                board[newX+1][i] = 0;
                            }

                        }

                    }

                }
            }
        }
    }

    static void findMax() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
    }
}
