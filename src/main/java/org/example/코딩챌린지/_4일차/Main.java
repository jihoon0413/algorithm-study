package org.example.코딩챌린지._4일차;

//import java.io.*;
//import java.util.*;
//
//public class Main {
//    static ArrayList<Integer>[] list;
//    static int[] ans;
//    static boolean[] check;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int N = Integer.parseInt(br.readLine());
//
//        list = new ArrayList[N + 1];
//        ans = new int[N + 1];
//        check = new boolean[N + 1];
//
//        for (int i = 1; i <= N; i++) {
//            list[i] = new ArrayList<>();
//        }
//
//        for (int i = 0; i < N - 1; i++) {
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            list[a].add(b);
//            list[b].add(a);
//        }
//
//        solve(1);
//
//
//        for (int i = 1; i <= N; i++) {
//            System.out.println(ans[i]);
//        }
//
//    }
//
//    static void solve(int start) {
//        check[start] = true;
//        boolean isLeaf = true;
//
//        for (int next : list[start]) {
//            if (!check[next]) {
//                isLeaf = false;
//                solve(next);
//                if (ans[next] == 0) {
//                    ans[start] = 1;
//                }
//            }
//        }
//
//        if (isLeaf) {
//            ans[start] = 1;
//        }
//    }
//}

// 정답 코드
import java.util.*;

class Main {
    static long n, a, b;
    static ArrayList<Long>[] v = new ArrayList[100050];
    static long[] dp = new long[100050];
    static final long inf = (long)1e12;


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        n=scanner.nextLong();

        for(int i=0;i<100050;i++)
            v[i]=new ArrayList<>();

        for(int i=1;i<n;i++){
            a=scanner.nextLong();
            b=scanner.nextLong();

            v[(int)a].add(b);
            v[(int)b].add(a);
        }

        dfs(1,0);

        for(int i=1;i<=n;i++){
            if(dp[i]>=0)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }

    static void dfs(long x, long par) {
        long ret = inf;
        for (Long nxt : v[(int)x]) {
            if (nxt == par) continue;
            dfs(nxt, x);
            ret = Math.min(ret, dp[nxt.intValue()]);
        }
        if (ret == inf) ret = 0;
        dp[(int)x] = x - ret;
    }

}