package org.example.백준.알고리즘중급_1.그리디알고리즘.회의실배정_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> times = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times.add(new Node(start,end));
        }

        times.sort(new Comparator<Node>() {
            @Override
            public int compare(Node i1, Node i2) {
                if (i1.end != i2.end) {
                    return Integer.compare(i1.end, i2.end);
                }
                return Integer.compare(i1.start, i2.start);
            }
        });

        int now = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            Node temp = times.get(i);
            int start = temp.start;
            int end = temp.end;

            if (start >= now) {
                now = end;
                count++;
            }
        }

        System.out.println(count);
    }
    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
