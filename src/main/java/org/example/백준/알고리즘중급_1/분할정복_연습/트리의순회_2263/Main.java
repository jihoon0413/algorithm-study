package org.example.백준.알고리즘중급_1.분할정복_연습.트리의순회_2263;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] inorder, inIdx, postorder;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());

        inorder = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        postorder = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        inIdx = new int[n+1];
        for(int i=1; i<n+1; i++) {
            inIdx[inorder[i]] = i;
        }

        solve(1,n,1,n);
        System.out.println(sb.toString());
    }

    /*
          1
      2       3
   4    5   6   7
 8   9

in   8 4 9 2 5 1 6 3 7
post 8 9 4 5 2 6 7 3 1
pre  1 2 4 8 9 5 3 6 7

 */
    static void solve(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return;
        int root = postorder[pe];
        int rIdx = inIdx[root];
        sb.append(root+" ");

        int len = rIdx - is;

        solve(is, rIdx-1, ps, ps+len-1);

        solve(rIdx+1, ie, ps+len, pe-1);
    }
}
