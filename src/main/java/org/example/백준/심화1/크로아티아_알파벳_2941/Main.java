package org.example.백준.심화1.크로아티아_알파벳_2941;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String sentence = scan.next();
        int count = 0;

        for(int i = 0 ; i < sentence.length() ; i++) {

            switch (sentence.charAt(i)) {
                case 'c':
                    switch (sentence.charAt(i + 1)) {
                        case '=', '-':
                            count++;
                            i += 1;
                            break;

                        default:
                            count++;

                    }
                    break;

                case 'd':
                    switch (sentence.charAt(i + 1)) {
                        case '-':
                            count++;
                            i += 1;
                            break;

                        case 'z':
                            if (sentence.charAt(i + 2) == '=') {
                                count++;
                                i += 2;
                            }
                            break;

                        default:
                            count++;
                    }
                    break;


                case 'l', 'n':
                    if (sentence.charAt(i + 1) == 'j') {
                        count++;
                        i += 1;
                    } else {
                        count++;
                    }
                    break;

                case 's', 'z':
                    if (sentence.charAt(i + 1) == '=') {
                        count++;
                        i += 1;
                    } else {
                        count++;
                    }
                    break;

                default: count++;
            }
        }

        System.out.println(count);

    }
}
