package org.example.백준.알고리즘중급_1.BFS_연습._4연산_14395;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long from = Long.parseLong(st.nextToken());
        long goal = Long.parseLong(st.nextToken());
        String ans = "";

        if(from == goal) {
            System.out.println(0);
            return;
        }

        Queue<Node> que = new LinkedList<>();
        boolean visitOne = false;

        que.offer(new Node(from, ""));

        while (!que.isEmpty()) {

            Node node = que.poll();

            if(node.num == goal) {
                ans = node.cal;
                break;
            }

            if(node.num == 0) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                long tempNum = node.num;
                String temp = node.cal;

                switch (i) {
                    case 0:
                        tempNum *= tempNum;
                        if(tempNum <= goal && tempNum != 1) {
                            que.offer(new Node(tempNum,temp+"*"));
                        }
                        break;
                    case 1:
                        tempNum += tempNum;
                        if(tempNum <= goal) {
                            que.offer(new Node(tempNum,temp+"+"));
                        }
                        break;
                    case 2:
                        tempNum -= tempNum;
                        if(tempNum <= goal) {
                            que.offer(new Node(tempNum,temp+"-"));
                        }
                        break;
                    case 3:
                        if(!visitOne) {
                            tempNum /= tempNum;
                            que.offer(new Node(tempNum, temp + "/"));
                            visitOne = true;
                        }
                        break;
                }
            }
        }

        if(Objects.equals(ans, "")) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);

    }

    static class Node{
        long num;
        String cal;

        public Node(long num, String cal) {
            this.num = num;
            this.cal = cal;
        }
    }
}
