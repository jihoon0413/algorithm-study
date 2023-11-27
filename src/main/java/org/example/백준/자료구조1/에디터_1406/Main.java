package org.example.백준.자료구조1.에디터_1406;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        LinkedList<String> linked = new LinkedList<>();

        for(int i = 0 ; i < word.length() ; i++) {

            linked.add(String.valueOf(word.charAt(i)));
        }

        int a = Integer.parseInt(br.readLine());

        ListIterator<String> listIt = linked.listIterator();

        while (listIt.hasNext()){
            listIt.next();
        }

        for(int i = 0 ; i < a ; i++ ) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String cmd = st.nextToken();


            switch(cmd){
                case "P":
                        listIt.add(st.nextToken());

                    break;
                case "L":
                    if(listIt.hasPrevious()) {
                        listIt.previous();
                    }
                    break;
                case "D":
                    if(listIt.hasNext()) {
                        listIt.next();
                    }
                    break;
                case "B":
                    if(listIt.hasPrevious()) {
                        listIt.previous();
                        listIt.remove();
                    }
                    break;
            }
        }

        for(String str : linked) {
            bw.write(str);
        }

        bw.flush();
        bw.close();



    }
}
