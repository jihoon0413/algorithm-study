package org.example.do_it._10_2트라이._72_문자열찾기_14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        List<String> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tNode root = new tNode();

        for(int i = 0 ; i < N ; i++) {
            tNode now = root;
            String str = br.readLine();
            // list.add(str);
            for(int j = 0 ; j < str.length() ; j++) {
                int c = str.charAt(j) - 'a';
                if(now.next[c] == null) {
                    now.next[c] = new tNode();
                }
                now = now.next[c];

                if(j == str.length() - 1) {
                    now.isEnd = true;
                }
            }

        }

        for(int i = 0 ; i < M ; i++) {
            String str = br.readLine();
            tNode now = root;
            // if(list.contains(str)) answer++;
            for(int j = 0 ; j < str.length() ; j++) {
                int c = str.charAt(j) - 'a';
                if(now.next[c] == null) {
                    break;
                }
                now = now.next[c];
                if(j == str.length() - 1 && now.isEnd) {
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }
    static class tNode {
        tNode[] next = new tNode[26];
        boolean isEnd;
    }
}
