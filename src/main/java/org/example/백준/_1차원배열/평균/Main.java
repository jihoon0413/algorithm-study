package org.example.백준._1차원배열.평균;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int subjectCount;
        double max;
        double total = 0;

        subjectCount = scan.nextInt();
        Subject[] subjects = new Subject[subjectCount];

        for(int i = 0 ; i < subjectCount ; i++) {
            subjects[i] = new Subject(scan.nextDouble());
        }

        max = subjects[0].score;

        for(int i = 1 ; i < subjectCount ; i++ ) {
            if(max < subjects[i].score) {
                max = subjects[i].score;
            }
        }

        for( int i = 0 ; i < subjectCount ; i++) {
            subjects[i].score = subjects[i].score / max * 100;
            total += subjects[i].score;
        }
        System.out.println(total/subjectCount);
    }
}

class Subject {
    double score;

    public Subject(double score) {
        this.score = score;
    }

}