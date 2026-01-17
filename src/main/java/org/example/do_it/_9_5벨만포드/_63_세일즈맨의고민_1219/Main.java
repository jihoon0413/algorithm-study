package org.example.do_it._9_5벨만포드._63_세일즈맨의고민_1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] result = new long[N];
        int[] city = new int[N];
        List<Edge> list = new ArrayList<>();
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            list.add(new Edge(s,e,p));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) {
            city[i] = Integer.parseInt(st.nextToken());
            result[i] = Long.MIN_VALUE;
        }

        result[S] = city[S];

        for(int i = 0 ; i <= N + 100 ; i++) {
            for(int j = 0 ; j < M ; j++) {
                Edge edge = list.get(j);
                if(result[edge.s] == Long.MIN_VALUE) {
                    continue;
                } else if(result[edge.s] == Long.MAX_VALUE) {
                    result[edge.e] = Long.MAX_VALUE;
                } else if(result[edge.e] < result[edge.s] + city[edge.e] - edge.p) {
                    result[edge.e] = result[edge.s] - edge.p + city[edge.e];
                    if(i > N - 1) result[edge.e] = Long.MAX_VALUE; // N 번 이상일 떄 업데이트가 일어나면 양의 사이클이 있다고 판단
                    // System.out.println(i + " 번째에 " + j + "의 엣지 리스트의 " + edge.e +"도시 " + result[edge.e]);
                }
            }
        }


        if(result[E] == Long.MIN_VALUE) {
            System.out.print("gg");
        } else if(result[E] == Long.MAX_VALUE) {
            System.out.print("Gee");
        } else {
            System.out.print(result[E]);
        }



    }
    static class Edge{
        int s,e,p;

        public Edge(int s, int e, int p) {
            this.s = s; //start
            this.e = e; //end
            this.p = p; //price
        }
    }


}
