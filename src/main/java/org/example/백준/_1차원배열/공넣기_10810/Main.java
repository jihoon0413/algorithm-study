package org.example.백준._1차원배열.공넣기_10810;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int bucketCount;
        int intoBucketCount;
        int startBucket, endBucket, ballNumber;

        bucketCount = scan.nextInt();
        intoBucketCount = scan.nextInt();


        Bucket[] buckets = new Bucket[bucketCount];
        for(int i = 0 ; i < bucketCount ; i++) {
            buckets[i] = new Bucket();
        }

        for(int i = 0 ; i < intoBucketCount ; i++) {
            startBucket = scan.nextInt();
            endBucket = scan.nextInt();
            ballNumber = scan.nextInt();

            for(int j = startBucket - 1 ; j < endBucket ; j++) {
                buckets[j].ballNumber = ballNumber;
            }
        }

        for(int i = 0 ; i < bucketCount ; i++) {
            System.out.print(buckets[i].ballNumber + " ");
        }

    }
}

class Bucket {
    int ballNumber;

    public Bucket() {
        this.ballNumber = 0;
    }
}
