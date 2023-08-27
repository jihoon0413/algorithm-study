package org.example.백준._1차원배열.바구니뒤집기_10811;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bucketCount;
        int changeCount;
        int bucket1;
        int bucket2;

        bucketCount = scan.nextInt();
        changeCount = scan.nextInt();

        Bucket[] buckets = new Bucket[bucketCount];

        for(int i = 0 ; i < bucketCount ; i++) {
            buckets[i] = new Bucket(i);
        }

        for(int i = 0 ; i < changeCount ; i++) {
            bucket1 = scan.nextInt();
            bucket2 = scan.nextInt();

            // 해당 범위만 역순한기

            int size = bucket2 - bucket1 + 1;
            int[] tempArray = new int[size];

            for(int j = 0 ; j < size ; j++ ) {
                tempArray[j] = buckets[bucket2-1-j].number;
            }

            for(int j = 0 ; j < size ; j++ ) {
                buckets[bucket1-1+j].number = tempArray[j];
            }

        }

        for(int i = 0 ; i < bucketCount ; i++) {
            System.out.print(buckets[i].number + " ");
        }



    }
}

class Bucket {
    int number;

    public Bucket(int number) {
        this.number = number + 1;
    }
}
