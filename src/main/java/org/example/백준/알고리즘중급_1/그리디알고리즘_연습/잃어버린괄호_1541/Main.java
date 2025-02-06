package org.example.백준.알고리즘중급_1.그리디알고리즘_연습.잃어버린괄호_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int size = st.countTokens();
        int[] ansList = new int[size];

        for (int i = 0; i < size; i++) {
            int temp = 0;
            String str = st.nextToken();
            StringTokenizer st2 = new StringTokenizer(str, "+");
            int size2 = st2.countTokens();
            for (int j = 0; j < size2; j++) {
                temp += Integer.parseInt(st2.nextToken());
            }
            ansList[i] = temp;
        }

        int ans = ansList[0];
        for (int i = 1; i < ansList.length; i++) {
            ans -= ansList[i];
        }

        System.out.println(ans);

    }
}
