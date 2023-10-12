package org.example.백준.심화1.너의평점은_25206;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double total = 0;
        double grade = 0;

        for(int i = 0 ; i < 20 ; i++) {

            String title = scan.next();

            double a = scan.nextDouble();

            String b = scan.next();


            if(!Objects.equals(b, "P")) {
                total += a;

                grade += (getIntGrade(b) *a );
            }


        }

        System.out.println(grade/total);

    }

    public static double getIntGrade(String grade) {

        switch (grade) {
            case "A+":
                return 4.5;

            case "A0":
                return 4.0;

            case "B+":
                return 3.5;

            case "B0":
                return 3.0;

            case "C+":
                return 2.5;

            case "C0":
                return 2.0;

            case "D+":
                return 1.5;

            case "D0":
                return 1.0;

            case "F":
                return 0.0;

        }
        return 0;
    }
}
