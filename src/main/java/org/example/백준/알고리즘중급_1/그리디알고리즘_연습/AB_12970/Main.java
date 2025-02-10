package org.example.백준.알고리즘중급_1.그리디알고리즘_연습.AB_12970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        if (K > (N - N / 2) * (N / 2)) {
            System.out.println(-1);
            return;
        }

        if (K == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N / 2; i++) {
                sb.append("B");
            }
            for (int i = 0; i < N - (N / 2); i++) {
                sb.append("A");
            }
            System.out.println(sb);
            return;

        }

        int start = N;

        while ((start - start / 2) * (start / 2) >= K) {
            start--;
        }

        start++;
        start = N - start;

        for (int i = 0; i < start; i++) {
            arr[i] = 0;
        }

        int countA = 0;
        int now = 0;
        for (int i = start; i < N; i++) {
            arr[i] = 1;
            countA++;
            if ((N - i - 1) * countA >= K) {
                now = (N - i - 1) * countA;
                start = i;
                break;
            }
        }

        if (now > K) {
            int count = now - K;
            arr[start + count] = 1;
            arr[start] = 0;

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                sb.append("B");
            } else {
                sb.append("A");
            }
        }
        System.out.println(sb);

//        int ALength = 0;
//        String s = "";
//        String[] result;
//        ALength = checkALength();
//        int BLength = N - ALength;
//        result = new String[N];
//        if(ALength != -1 && K != 0) {
//            for(int i=0; i<N; i++) {
//                result[i] = "B";
//            }
//            for(int i=0; i<ALength-1; i++) {
//                result[i] = "A";
//            }
//            int c = (ALength - 1) * BLength;
//            int r = K - c;
//            result[(N-1)-r] = "A";
//        }
//        else if (K == 0) {
//            for(int i=0; i<N; i++) {
//                result[i] = "B";
//            }
//        }
//        System.out.println(ALength == -1 ? -1 : String.join("", result));
//    }
//    public static int checkALength() {
//        int ALength = 1;
//        int BLength = N - 1;
//        while(ALength*BLength < K) {
//            if(BLength < 0) return -1;
//            ALength++;
//            BLength--;
//        }
//        return ALength;
//    }

    }
}
