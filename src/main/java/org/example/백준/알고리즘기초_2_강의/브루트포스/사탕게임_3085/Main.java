package org.example.백준.알고리즘기초_2_강의.브루트포스.사탕게임_3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;
    static int a;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(br.readLine());

        arr = new char[a+1][a+1];
        int ans = 0;

        for(int i = 1 ; i <= a ; i++) {
            String str = br.readLine();
            for(int j = 1 ; j <= a ; j++) {
                arr[i][j] = str.charAt(j-1);
            }
        }

        for(int i = 1 ; i <= a ; i++) {
            for(int j = 1 ; j < a ; j++) {
                if(arr[i][j] != arr[i][j+1]) {
                    ans = Math.max(ans,swapColumn(i,j));
                }
                if(arr[j][i] != arr[j+1][i]) {
                    ans = Math.max(ans, swapRow(j,i));
                }
            }
        }

        for(int i = 1 ; i <= a ; i++) {
            char temp = arr[i][1];
            boolean flag = true;
            for(int j = 1 ; j <= a ; j++) {
                if(temp != arr[i][j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) ans = a;
        }

        for(int i = 1 ; i <= a ; i++) {
            char temp = arr[1][i];
            boolean flag = true;
            for(int j = 1 ; j <= a ; j++) {
                if(temp != arr[j][i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) ans = a;
        }

        System.out.println(ans);

    }
    static int swapRow(int row, int column) {
        int ans = 0;

        char temp = arr[row][column];
        arr[row][column] = arr[row+1][column];
        arr[row+1][column]=temp;


        ans = Math.max(checkRow(row, arr[row][column]),Math.max(checkRow(row+1, arr[row+1][column]),Math.max(checkColumn(column,arr[row][column]),checkColumn(column,arr[row+1][column]))));

        temp = arr[row][column];
        arr[row][column] = arr[row+1][column];
        arr[row+1][column]=temp;

        return ans;
    }

    static int swapColumn(int row, int column) {
        int ans = 0;

        char temp = arr[row][column];
        arr[row][column] = arr[row][column+1];
        arr[row][column+1]=temp;


        ans = Math.max(checkRow(row, arr[row][column]),Math.max(checkRow(row, arr[row][column+1]),Math.max(checkColumn(column,arr[row][column]) ,checkColumn(column+1,arr[row][column+1]))));

        temp = arr[row][column];
        arr[row][column] = arr[row][column+1];
        arr[row][column+1]=temp;

        return ans;
    }

    static int checkRow(int row, char c) {
        int length = 0;
        int ans = 0;

        for(int i = 1 ; i <= a ; i++) {
            if(arr[row][i] == c) {
                length += 1;
                ans = Math.max(ans,length);
            } else {
                length = 0;
            }
        }

        return ans;
    }

    static int checkColumn(int column, char c) {
        int length = 0;
        int ans = 0;

        for(int i = 1 ; i <= a ; i++) {
            if(arr[i][column] == c) {
                length += 1;
                ans = Math.max(ans,length);
            } else {
                length = 0;
            }
        }

        return ans;
    }

}
