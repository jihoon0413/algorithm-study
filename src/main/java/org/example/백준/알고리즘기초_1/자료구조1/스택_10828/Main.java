package org.example.백준.알고리즘기초_1.자료구조1.스택_10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        Stack stack = new Stack(a);


        for(int i = 0 ; i < a ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String cmd = st.nextToken();

            switch(cmd){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;
            }


        }
    }

    public static class Stack {

        int[] stack;
        int size = 0;

        Stack(int a) {
            stack = new int[a];
        }

        void push(int num) {
            stack[size] = num;
            size++;
        }

        void pop() {
            if(size == 0) {
                System.out.println(-1);
            } else {
                int result = stack[size-1];
                size--;
                System.out.println(result);

            }
        }

         void size() {
             System.out.println(size);
        }

        void empty() {
            if(size == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        void top() {
            if(size == 0 ) {
                System.out.println(-1);
            } else {
                System.out.println(stack[size-1]);
            }
        }

    }
}
