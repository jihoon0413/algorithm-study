package org.example.백준.알고리즘중급_1.분할정복_연습.사분면_1891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String goal = st.nextToken();

        st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long size = (long) Math.pow(2, N);
        Loc loc = find(1, size, 1, size, goal);

        long nowX = loc.x - y;
        long nowY = loc.y + x;

        if(nowX < 1 || nowX > size || nowY < 1 || nowY > size) {
            System.out.println(-1);
            return;
        }

        findSection(1, size, 1, size, new Loc(nowX, nowY));

        System.out.println(sb);

    }

    static Loc find(long sx, long ex, long sy , long ey, String goal) {

        if(Objects.equals(goal, "")) {
            return new Loc(sx, sy);
        }
        int temp = goal.charAt(0)-'0';
        String newGoal = goal.substring(1);

        if(temp == 1) {
            return find(sx, (sx+ex)/2, (sy+ey)/2+1, ey, newGoal);
        } else if (temp == 2) {
            return find(sx, (sx+ex)/2, sy, (sy+ey)/2, newGoal);
        } else if (temp == 3) {
            return find((sx+ex)/2 + 1, ex, sy, (sy+ey)/2, newGoal);
        } else {
            return find((sx+ex)/2 + 1, ex, (sy+ey)/2+1, ey, newGoal);
        }
    }

    static void findSection(long sx, long ex, long sy, long ey, Loc loc) {
        if(sx == ex && sy == ey) {
            return;
        }

        long x = loc.x;
        long y = loc.y;

        if(x <= (sx+ex)/2 && (sy+ey)/2 < y) {
            sb.append(1);
            findSection(sx, (sx+ex)/2, (sy+ey)/2+1, ey, loc);
        } else if (x <= (sx+ex)/2 && y <= (sy + ey)/2) {
            sb.append(2);
            findSection(sx, (sx+ex)/2, sy, (sy+ey)/2, loc);
        } else if((sx+ex)/2 < x && y <= (sy + ey)/2) {
            sb.append(3);
            findSection((sx+ex)/2 + 1, ex, sy, (sy+ey)/2, loc);
        } else if ((sx+ex)/2 < x && (sy+ey)/2 < y) {
            sb.append(4);
            findSection((sx+ex)/2 + 1, ex, (sy+ey)/2+1, ey, loc);
        }
    }

    public static class Loc {
        long x;
        long y;

        public Loc(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}

/*

21
32 31 42 41
33 342 341 432 431 44
   343 344 433 434

 */