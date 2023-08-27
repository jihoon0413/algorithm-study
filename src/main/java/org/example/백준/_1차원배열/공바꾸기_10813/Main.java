package org.example.백준._1차원배열.공바꾸기_10813;

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

            int tempBallNumber = buckets[bucket1-1].ballNumber;
            buckets[bucket1-1].ballNumber = buckets[bucket2-1].ballNumber;
            buckets[bucket2-1].ballNumber = tempBallNumber;

        }

        for(int i = 0 ; i < bucketCount ; i++) {
            System.out.print(buckets[i].ballNumber + " ");
        }



    }
}

class Bucket {
    int ballNumber;

    public Bucket(int ballNumber) {
        this.ballNumber = ballNumber + 1;
    }
}

