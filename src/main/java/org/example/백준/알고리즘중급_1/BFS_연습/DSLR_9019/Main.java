package org.example.백준.알고리즘중급_1.BFS_연습.DSLR_9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb = new StringBuilder();
            min = Integer.MAX_VALUE;
            visit = new boolean[10000];
            visit[a] = true;
            solve(a, b);
            System.out.println(sb);
        }

    }

    static void solve(int a,int b) {

        Queue<List<Integer>> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(0);
        que.offer(list);


        while (!que.isEmpty()) {
            List<Integer> temp = que.poll();
            int num = temp.get(0);
            int count = temp.get(1);

            if(num == b) {
                if(count < min) {
                    min = count;
                    sb = new StringBuilder();
                    for (int i = 2; i < 2 + count; i++) {
                        switch (temp.get(i)) {
                            case 0:
                                sb.append('D');
                                break;
                            case 1:
                                sb.append('S');
                                break;
                            case 2:
                                sb.append('L');
                                break;
                            case 3:
                                sb.append('R');
                                break;
                        }
                    }
                }
                return;
            }


            if(count > min) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newNum = 0;
                switch (i) {
                    case 0:
                        newNum = D(num);
                        break;
                    case 1:
                        newNum = S(num);
                        break;
                    case 2:
                        newNum = L(num);
                        break;
                    case 3:
                        newNum = R(num);
                        break;

                }
                if(!visit[newNum]) {
                    visit[newNum] = true;
                    List<Integer> temp2 = new ArrayList<>(temp);
                    temp2.set(0,newNum);
                    temp2.set(1,count+1);
                    temp2.add(i);
                    que.offer(temp2);
                }
            }

        }
    }

    static int D(int nowNum) {
        int num = nowNum;
        num = (num*2)%10000;

        return num;
    }

    static int S(int nowNum) {
        int num = nowNum;
        num -= 1;
        if(num < 0) {
            num = 9999;
        }
        return num;
    }

    static int L(int nowNum) {
        return nowNum % 1000 * 10 + nowNum / 1000;
//        int[] num = new int[4];
//        for (int j = 0; j < 4; j++) {
//            num[3-j] = nowNum%10;
//            nowNum /= 10;
//        }
//
//        int temp = num[0];
//        for (int i = 0; i < 3; i++) {
//            num[i] = num[i+1];
//        }
//        num[3] = temp;
//
//        temp = 0;
//        for (int i = 0; i < 4; i++) {
//            temp = temp * 10 + num[i];
//        }
//        return temp;
    }

    static int R(int nowNum) {
        return nowNum % 10 * 1000 + nowNum / 10;
//        int[] num = new int[4];
//        for (int j = 0; j < 4; j++) {
//            num[3-j] = nowNum%10;
//            nowNum /= 10;
//        }
//
//        int temp = num[3];
//        for (int i = 0; i < 3; i++) {
//            num[3-i] = num[3-(i+1)];
//        }
//        num[0] = temp;
//
//        temp = 0;
//        for (int i = 0; i < 4; i++) {
//            temp = temp * 10 + num[i];
//        }
//        return temp;
    }
}
