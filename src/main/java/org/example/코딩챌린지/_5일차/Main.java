package org.example.코딩챌린지._5일차;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static boolean[] check;
//    static List<Integer> ans = new ArrayList<>();
//    static List<Integer> arr = new ArrayList<>();
//    static int count;
//    static int n;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        n = Integer.parseInt(br.readLine());
//
//        count = (int) Math.pow(2,n);
//
//
//        check = new boolean[count];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < count; i++) {
//            arr.add(Integer.parseInt(st.nextToken()));
//        }
//
//        Collections.sort(arr);
//
//        check[0] = true;
//
//        int index = 1;
//        while(true) {
//            solve(0, 0, index);
//            for (int i = 0; i < count; i++) {
//                if (!check[i]) {
//                    ans.add(arr.get(i));
//                    check[i] = true;
//                    index++;
//                    break;
//                }
//            }
//            if (ans.size() == n) {
//                break;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        for(int i : ans) {
//            sb.append(i).append(" ");
//        }
//        System.out.println(sb);
//
//    }
//    static void solve(int a, int sum, int index) {
//
//
//
//        for (int i = index; i < count; i++) {
//            if(!check[i]) {
//                if (sum == arr.get(i)) {
//                    check[i] = true;
//                    break;
//                }
//            }
//        }
//
//        if(a >= ans.size()) {
//            return;
//        }
//
//        if(a == n) {
//            return;
//        }
//
//        solve(a+1, sum+ans.get(a), index);
//
//        solve(a+1, sum, index);
//
//    }
//}


//정답코드

import java.util.*;

public class Main {
    static ArrayList<Long> res = new ArrayList<>();
    static ArrayList<Long> now = new ArrayList<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Long> v = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            long a = scanner.nextLong();
            v.add(a);
        }

        Collections.sort(v);

        for (int i = 1; i < v.size(); i++) {
            if (!now.contains(v.get(i))) {
                long m = v.get(i);
                dfs(res, 0, 0, now, m);
                res.add(v.get(i));
            }
            now.remove(v.get(i));
        }

        for (long nxt : res) {
            System.out.print(nxt + " ");
        }
        System.out.println();
    }
    public static void dfs(ArrayList<Long> res, int x, long sum_, ArrayList<Long> now, long m) {
        if (x == res.size()) {
            now.add(sum_ + m);
            return;
        }
        dfs(res, x + 1, sum_, now, m);
        dfs(res, x + 1, sum_ + res.get(x), now, m);
    }

}
