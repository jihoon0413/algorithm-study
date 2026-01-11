package org.example.do_it._9_2유니온파인드._55_거짓말쟁이가되긴싫어_1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static List<List<Integer>> list  = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i = 0; i <= N ; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < M ; i++) {
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int knowCount = Integer.parseInt(st.nextToken());
        int[] know = new int[knowCount];
        for(int i = 0 ; i < knowCount ; i++) {
            know[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < count ; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0 ; i < M ; i++) {
            int count = list.get(i).size();
            int first = list.get(i).get(0);
            for(int j = 0 ; j < count ; j++) {
                union(first, list.get(i).get(j));
            }
        }

        for(int i = 0 ; i < M ; i++) {
            boolean flag = true;
            int now = parent[list.get(i).get(0)];
            for(int j = 0 ; j < knowCount ; j++) {
                if(find(now) == find(know[j])) {
                    flag =  false;
                    break;
                }
            }
            if(flag) answer++;
        }


        System.out.println(answer);

    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if(a == parent[a]) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}
