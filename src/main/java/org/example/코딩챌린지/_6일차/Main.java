package org.example.코딩챌린지._6일차;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int[] color;
//    static List<Integer>[] list;
//    static int n;
//    static int ans = Integer.MAX_VALUE;
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        n = Integer.parseInt(br.readLine());
//        list = new ArrayList[n];
//        color = new int[n-1];
//
//        for (int i = 0; i < n; i++) {
//            list[i] = new ArrayList<>();
//        }
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n-1 ; i++) {
//            color[i] = Integer.parseInt(st.nextToken());
//        }
//
//        solve(0, 0, 1, 0);
//
//        System.out.println(ans);
//
//    }
//    static void solve(int node, int idx, int count, int red) {
//
//        if(count == n) {
//            ans = Math.min(ans, red);
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if(!list[node].contains(i) && node != i) {
//                List<Integer> temp = new ArrayList<>();
//                temp.add(node);
//                temp.addAll(list[node]);
//
//                for (int a : list[node]) {
//                    list[a].addAll(list[i]);
//                    list[a].add(i);
//                }
//                list[node].addAll(list[i]);
//                list[node].add(i);
//
//                list[i].addAll(temp);
//
//                if(color[idx] == 0) {
//                    solve(i, idx + 1,count + 1, red + temp.size());
//                    for (int j = 0; j < n; j++) {
//                        if(!list[node].contains(j)) {
//                            solve(j, idx + 1, count + 1, red + temp.size());
//
//                        }
//                    }
//                } else {
//                    solve(i, idx + 1, count + 1, red);
//                    for (int j = 0; j < n; j++) {
//                        if(!list[node].contains(j)) {
//                            solve(j, idx + 1, count + 1, red);
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

//정답코드
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            a[i] = scanner.nextInt();
        }
        Map<List<Integer>, Integer> dp = new HashMap<>();
        dp.put(new ArrayList<>(Collections.nCopies(N, 1)), 0);
        Deque<List<Integer>> queue = new ArrayDeque<>();
        queue.add(new ArrayList<>(Collections.nCopies(N, 1)));
        while (!queue.isEmpty()) {
            List<Integer> v = queue.pollFirst();
            for (int i = 0; i < v.size(); i++) {
                for (int j = i + 1; j < v.size(); j++) {
                    List<Integer> u = new ArrayList<>();
                    for (int k = 0; k < v.size(); k++) {
                        if (k == i) {
                            u.add(v.get(i) + v.get(j));
                        } else if (k != j) {
                            u.add(v.get(k));
                        }
                    }
                    Collections.sort(u);
                    if (!dp.containsKey(u)) {
                        queue.add(u);
                        dp.put(u, dp.get(v) + (1 - a[N - v.size()]) * v.get(i) * v.get(j));
                    } else {
                        dp.put(u, Math.min(dp.get(u), dp.get(v) + (1 - a[N - v.size()]) * v.get(i) * v.get(j)));
                    }
                }
            }
        }
        System.out.println(dp.get(Collections.singletonList(N)));
    }
}

