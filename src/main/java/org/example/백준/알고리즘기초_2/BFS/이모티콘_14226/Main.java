package org.example.백준.알고리즘기초_2.BFS.이모티콘_14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int ans = 0;
    static boolean[][] check = new boolean[1001][1001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());

        if(S != 1) {
            solve(S);
        }

        System.out.println(ans);

    }
    static void solve(int S) {

        Queue<Emo> que = new LinkedList<>();
        check[1][0] = true;
        que.offer(new Emo(1, 0, 0));
        // 길이, 클립보드길이, 시간

        while (!que.isEmpty()) {

            Emo temp = que.poll();

            int length = temp.length;
            int clip = temp.clip;
            int time = temp.time;

            int newTime = time+1;

            for (int i = 0; i < 3; i++) {
                int newLength;
                int newClip;

                if(i == 0) {
                    newLength = length;
                    newClip = length;
                } else if(i == 1) {
                    newLength = length + clip;
                    newClip = clip;
                } else {
                    newLength = length - 1;
                    newClip = clip;
                }

                if(newLength == S) {
                    ans = newTime;
                    return;
                }

                if(newLength >= 0 && newLength < 1001 && newClip != 0) {
                    if(!check[newLength][newClip]) {
                        check[newLength][newClip] = true;
                        que.offer(new Emo(newLength, newClip, newTime));
                    }
                }

            }
        }
    }

    static class Emo {
        int length, clip,time;

        Emo(int length, int clip, int time) {
            this.length = length;
            this.clip = clip;
            this.time = time;
        }
    }
}
