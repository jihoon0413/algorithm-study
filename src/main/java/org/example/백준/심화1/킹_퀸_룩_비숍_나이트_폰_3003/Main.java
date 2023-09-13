package org.example.백준.심화1.킹_퀸_룩_비숍_나이트_폰_3003;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dong = new int[6];

    for(int i = 0 ; i < dong.length ; i++) {
        dong[i] = scan.nextInt();
    }

    Chess chess = new Chess();

    chess.compare(dong);

//    for(int i  = 0 ; i < dong.length ; i++) {
//        System.out.print(chess.count[i] - dong[i] + " ");
//    }
    }
}

class Chess {
    int[] count = new int[] {1,1,2,2,2,8};

    public void compare(int[] array){
        for(int i  = 0 ; i < array.length ; i++) {
            System.out.print(count[i] - array[i] + " ");
        }
    }
}