package org.example.백준.알고리즘기초_1.자료구조1.에디터_1406;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        Stack<String> stackFront = new Stack<>();
        Stack<String> stackBehind = new Stack<>();


        for(int i = 0 ; i < word.length() ; i++) {
            stackFront.add(String.valueOf(word.charAt(i)));
        }

        int a = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < a ; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String cmd = st.nextToken();


            switch(cmd){
                case "P":
                    stackFront.push(st.nextToken());

                    break;
                case "L":

                    if(!stackFront.isEmpty()) {
                        stackBehind.push(stackFront.pop());
                    }

                    break;
                case "D":
                    if(!stackBehind.isEmpty()) {
                        stackFront.push(stackBehind.pop());
                    }
                    break;
                case "B":
                    if(!stackFront.isEmpty()) {
                        stackFront.pop();
                    }
                    break;
            }
        }

        while (!stackFront.isEmpty()) {
            stackBehind.push(stackFront.pop());
        }

        while (!stackBehind.isEmpty()) {
            bw.write(stackBehind.pop());
        }

        bw.flush();
        bw.close();


    }
}
