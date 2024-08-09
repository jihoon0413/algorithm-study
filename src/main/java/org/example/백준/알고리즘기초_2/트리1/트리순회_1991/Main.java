package org.example.백준.알고리즘기초_2.트리1.트리순회_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] lists;
    static int N;
    static boolean[] check;
    static ArrayList<Integer> ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        N = Integer.parseInt(br.readLine());
        check = new boolean[N];

        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A';
            int b = st.nextToken().charAt(0) - 'A';
            int c = st.nextToken().charAt(0) - 'A';
            lists[a].add(b);
            lists[a].add(c);

        }

        ans = new ArrayList<>();
        sb = new StringBuilder();
        front(0);
        for(int a : ans) {
            sb.append((char) (a+'A'));
        }
        System.out.println(sb);

        ans = new ArrayList<>();
        sb = new StringBuilder();
        middle(0);
        for(int a : ans) {
            sb.append((char) (a+'A'));
        }
        System.out.println(sb);

        ans = new ArrayList<>();
        sb = new StringBuilder();
        back(0);
        for(int a : ans) {
            sb.append((char) (a+'A'));
        }
        System.out.println(sb);
    }

    static void front(int a) {
        ans.add(a);
        for (int temp : lists[a]) {
            if(temp != -19) {
                front(temp);
            }
        }
    }

    static void middle(int a) {

        for (int i = 0; i <2 ; i++) {
            int temp = lists[a].get(i);
            if(i == 1) {
                ans.add(a);
            }
            if(i == 0 && temp != - 19) {
                middle(temp);
            } else if(temp != -19){
                middle(temp);
            }
        }
    }

    static void back(int a) {

        for (int temp : lists[a]) {
            if(temp != -19) {
                back(temp);
            }
        }
        ans.add(a);
    }
}
