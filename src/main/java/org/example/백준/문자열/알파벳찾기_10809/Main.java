package org.example.백준.문자열.알파벳찾기_10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        for(char word ='a' ; word <= 'z' ; word++) {

            boolean flag = false;
            int location = 0;

            for( int i = 0 ; i < s.length() ; i++) {
                if(s.charAt(i) == word) {
                    flag = true;
                    location = i;
                    break;
                }
            }

            if(flag) {
                System.out.print(location + " ");
            } else {
                System.out.print(-1 + " ");
            }
        }
    }
}



//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int[] arr = new int[26];
//
//        for(int i = 0; i < arr.length; i++) {
//            arr[i] = -1;
//        }
//
//        String S = br.readLine();
//
//        for(int i = 0; i < S.length(); i++) {
//            char ch = S.charAt(i);
//
//           if(arr[ch - 'a'] == -1) {
//               arr[ch - 'a'] = i;
//           }
//        }
//
//        for(int val : arr) {	// 배열 출력
//            System.out.print(val + " ");
//        }
//    }
//}
