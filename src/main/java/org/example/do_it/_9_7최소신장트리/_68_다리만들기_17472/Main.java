package org.example.do_it._9_7최소신장트리._68_다리만들기_17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] parent;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] temp;
    static int N, M;
    static PriorityQueue<Edge> list = new PriorityQueue<>((o1,o2) -> {
        return o1.l - o2.l;
    });
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];


        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 지도 만들기 -> map, visited 사용
        int islandIdx = 1;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    makeMap(i, j, islandIdx);
                    islandIdx++;
                }
            }
        }

        // for(int i = 0 ; i < N ; i++) {
        //   for(int j = 0 ; j < M ; j++) {
        //     System.out.print(map[i][j] + " ");
        //   }
        //   System.out.println();
        // }

        // 엣지 리스트 만들기( 다리 길이가 2 이상!! )  -> list
        // ==================================================================
        visited = new boolean[islandIdx][islandIdx];
        temp = new int[islandIdx][islandIdx];
        for(int i = 0 ; i < islandIdx ; i++) {
            for(int j = 0 ; j < islandIdx ; j++) {
                temp[i][j] = 20;
            }
        }

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(map[i][j] != 0) {
                    findEdge(i, j, map[i][j]);
                }
            }
        }


        for(int i = 1 ; i < islandIdx - 1 ; i++) {
            for(int j = i + 1 ; j < islandIdx ; j++) {
                if(temp[i][j] != 20 && temp[i][j] > 2) {
                    // System.out.println(i + ", " + j + " : " + (temp[i][j]-1));
                    list.add(new Edge(i, j, temp[i][j]-1));
                }
            }
        }

        // for(int i = 1 ; i < islandIdx ; i++) {
        //   for(int j = 1 ; j < islandIdx ; j++) {
        //     System.out.print(temp[i][j] + " ");
        //   }
        //   System.out.println();
        // }

        //=========================================================================
        // 최소 신장트리 -> find() 값이 다르면 union 가중치 누적합

        parent = new int[islandIdx]; // 1부터
        for(int i = 0 ; i < islandIdx ; i++) {
            parent[i] = i;
        }

        while(!list.isEmpty()) { // islandIdx - 1 만큼 반복
            Edge edge = list.poll();
            int s = edge.s;
            int e = edge.e;
            if(find(s) != find(e)) {
                union(s,e);
                answer += edge.l;
            }
        }

        // 출력 모든 곳에서 find()값이 같으면 가중치 누적합 출력 아니면 -1 출력
        // parent 는 1부터 islandIdx까지가 섬
        // System.out.print(islandIdx);
        int first = find(parent[1]);
        boolean flag = true;
        for(int i = 2 ; i < islandIdx ; i++) {
            if(first != find(i)) {
                flag = false;
                break;
            }
        }

        if(flag) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

    }

    // 메소드 모음 ========================================================
    static void findEdge(int a, int b, int idx) {
        for(int i = 0 ; i < 4 ; i++) {
            int x = a;
            int y = b;
            int count = 0;
            while(true) {
                x += dx[i];
                y += dy[i];
                count++;

                if(x < 0 || x >= N || y < 0 || y >= M) {
                    break;
                }

                if(map[x][y] != 0 ) {
                    if(map[x][y] != idx && count > 2) {
                        temp[idx][map[x][y]] = Math.min(temp[idx][map[x][y]], count);
                        break;
                    }
                    break;
                }
            }
        }


    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if(parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    static void makeMap(int a, int b, int idx) {
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{a,b});
        visited[a][b] = true;
        map[a][b] = idx;

        while(!que.isEmpty()) {
            int[] now = que.poll();

            int x = now[0];
            int y = now[1];

            for(int i = 0 ; i < 4 ; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX < 0 || newX >= N || newY < 0 || newY >= M) {
                    continue;
                }

                if(!visited[newX][newY] && map[newX][newY] != 0) {
                    map[newX][newY] = idx;
                    visited[newX][newY] = true;
                    que.add(new int[] {newX,newY});
                }
            }
        }
    }
    static class Edge {
        int s,e,l;

        public Edge(int s, int e, int l) {
            this.s = s;
            this.e = e;
            this.l = l;
        }
    }

}

