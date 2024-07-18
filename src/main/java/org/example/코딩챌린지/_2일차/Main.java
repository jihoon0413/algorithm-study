package org.example.코딩챌린지._2일차;

//import java.io.*;
//import java.util.*;
//
////정리정돈을 좋아하는 K씨
//
//class Main {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        int[] arr = new int[n+1];
//
//        st = new StringTokenizer(br.readLine());
//
//        for(int i = 1 ; i <= n ; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        for(int i = 0 ; i < m ; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            int start = Integer.parseInt(st.nextToken());
//            int end = Integer.parseInt(st.nextToken());
//            int k = Integer.parseInt(st.nextToken());
//            int count = end - start + 1;
//            int[] temp = new int[count];
//
//            for(int j = start ; j <= end ; j++) {
//                temp[j-start] = arr[j];
//            }
//
//            Arrays.sort(temp);
//
//            sb.append(temp[k-1]).append('\n');
//
//        }
//
//        System.out.print(sb);
//
//    }
//}

//정답코드
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> seq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seq.add(sc.nextInt());
        }
        for (int cnt = 0; cnt < m; cnt++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> part = new ArrayList<>(seq.subList(i - 1, j));
            Collections.sort(part);
            System.out.println(part.get(k - 1));
        }
        sc.close();
    }
}
