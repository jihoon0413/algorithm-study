package org.example.백준.알고리즘중급_1.그리디알고리즘.가장긴증가하는부분수열_12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        List<Integer> ans = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans.add(arr[0]);
        for (int i = 1; i < N; i++) {

            int temp = arr[i];

            if(ans.get(ans.size()-1) < temp) {
                ans.add(temp);
            } else {
                int min = 0;
                int max = ans.size()-1;
                while (min < max) {
                    int mid = (min + max) / 2;
                    if(ans.get(mid) >= temp) {
                        max = mid;
                    } else {
                        min = mid+1;
                    }
                }
                ans.set(max, temp);

            }
        }
        System.out.println(ans.size());
    }
}
