package org.example.백준.알고리즘기초_1.자료구조1_연습.쇠막대기_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();
        String word = br.readLine();

        int total = 0;

        for(int i = 0 ; i < word.length() ; i++ ) {
            if(word.charAt(i) == '(') {
                if(word.charAt(i+1) == ')'){
                    total += list.size();
                    i++;
                } else {
                    list.add(1);
                    total += 1;
                }
            } else if ( word.charAt(i) == ')') {
                if(!list.isEmpty()) {
                    list.pollLast();
                }
            }
        }
        System.out.println(total);
    }
}