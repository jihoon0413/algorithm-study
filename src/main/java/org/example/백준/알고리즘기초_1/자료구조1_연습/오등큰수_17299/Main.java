package org.example.백준.알고리즘기초_1.자료구조1_연습.오등큰수_17299;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int[] num = new int[a];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < a ; i++ ) {
            num[i] = Integer.parseInt(st.nextToken());

            if(!map.containsKey(num[i])) {
                map.put(num[i],1);
            } else {
                map.replace(num[i], map.get(num[i]) + 1);
            }
        }

        for(int i = 0 ; i < a ; i++ ) {

            while (!stack.isEmpty() && map.get(num[stack.peek()]) < map.get(num[i])) {
                num[stack.pop()] = num[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            num[stack.pop()] = -1;
        }

        for(int i = 0 ; i < a ; i++ ) {
            sb.append(num[i]).append(" ");
        }

        System.out.println(sb);
    }
}
