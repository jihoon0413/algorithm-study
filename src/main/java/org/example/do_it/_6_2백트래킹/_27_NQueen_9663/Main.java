package org.example.do_it._6_2백트래킹._27_NQueen_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] A;
    static int N;
    static int answer= 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        backtracking(0);

        System.out.println(answer);

    }

    static void backtracking(int row) {
        if(row == N) {
            answer++;
            return;
        }

        for(int i = 0 ; i < N ; i++) {
            A[row] = i;

            if(validate(row)) {
                backtracking(row+1);
            }
        }
    }

    static boolean validate(int row) {
        boolean flag = true;
        for(int i = 0 ; i <row ; i++) {
            if(A[row] == A[i] || Math.abs(row-i) == Math.abs(A[row] - A[i])) {
                flag = false;
                break;
            }
        }
        return flag;

    }
}

