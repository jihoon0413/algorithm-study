package org.example.백준.알고리즘기초_1_강의.자료구조1.요세푸스문제_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        LinkedList<Integer> linked = new LinkedList<>();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < a ; i++) {
            linked.add(i+1);
        }

        ListIterator<Integer> iterator = linked.listIterator();

        while (!linked.isEmpty()) {

            for(int i = 0 ; i < b ; i++) {
                if(!iterator.hasNext()){
                    while (iterator.hasPrevious()){
                        iterator.previous();
                    }
                }
                    iterator.next();
            }
            if(!iterator.hasPrevious()){
                while(iterator.hasNext()){
                    iterator.next();
                }
            }

            sb.append(iterator.previous());
            iterator.remove();

            if(linked.isEmpty()){
                break;
            } else {
                sb.append(", ");
            }

        }

        sb.append(">");
        System.out.println(sb);


    }
}
