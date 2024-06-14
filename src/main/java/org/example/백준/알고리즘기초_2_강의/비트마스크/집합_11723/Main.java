package org.example.백준.알고리즘기초_2_강의.비트마스크.집합_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();
            int num = 0;
            if(st.hasMoreElements()) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (order) {
                case "add":
                    list.add(num);
                    break;
                case "remove":
                    list.remove((Object) num);
                    break;
                case "check":
                    if(list.contains(num)) {
                        sb.append(1).append("\n");
                    }else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    if(list.contains(num)) {
                        list.remove((Object) num);
                    }else {
                        list.add(num);
                    }
                    break;
                case "all":
                    list.clear();
                    for(int j = 1 ; j <= 20 ; j++) {
                        list.add(j);
                    }
                    break;
                case "empty":
                    list.clear();
                    break;
            }
        }

        System.out.println(sb);
        
    }
}
