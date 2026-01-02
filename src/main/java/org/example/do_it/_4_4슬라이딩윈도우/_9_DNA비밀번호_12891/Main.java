package org.example.do_it._4_4슬라이딩윈도우._9_DNA비밀번호_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] count = new int[26];
    public static int[] dna = new int[4];
    public static int[] idxs = {0,2,6,19};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();
        int length = str.length();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++) {
            dna[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int g = P-1;

        for(int i = s ; i <= g ; i++) {
            count[str.charAt(i)-'A']++;
        }

        while(g != length-1) {
            if(check()) {
                answer++;
            }
            count[str.charAt(s)-'A']--;
            s++;
            g++;
            count[str.charAt(g)-'A']++;
        }

        if(check()) {
            answer++;
        }
        System.out.println(answer);
    }

    public static boolean check() {
        for(int i = 0 ; i < 4 ; i++) {
            if(count[idxs[i]] < dna[i]) {
                return false;
            }
        }
        return true;
    }
}
