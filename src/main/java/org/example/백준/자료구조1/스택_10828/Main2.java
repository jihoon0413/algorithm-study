package org.example.백준.자료구조1.스택_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] stack;
    static int size = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        stack = new int[a];


        for(int i = 0 ; i < a ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String cmd = st.nextToken();

            switch(cmd){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
            }


        }
    }

        static void push(int num) {
            stack[size] = num;
            size++;
        }

        static void pop() {
            if(size == 0) {
                System.out.println(-1);
            } else {
                int result = stack[size-1];
                size--;
                System.out.println(result);

            }
        }

        static void size() {
            System.out.println(size);
        }

        static void empty() {
            if(size == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        static void top() {
            if(size == 0 ) {
                System.out.println(-1);
            } else {
                System.out.println(stack[size-1]);
            }
        }


}