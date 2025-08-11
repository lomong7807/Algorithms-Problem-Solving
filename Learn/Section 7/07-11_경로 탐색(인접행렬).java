import java.io.*;
import java.util.*;
/*
 * 문제: 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
        아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
        1 2 3 4 5
        1 2 5
        1 3 4 2 5
        1 3 4 5
        1 4 2 5
        1 4 5
        총 6가지이다.
 * 입력: 첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
 * 출력: 총 가지수를 출력한다.
 * 풀이후기:
 *  - 일반적인 트리 구조만 보다가 그래프를 보니까 더 신경쓸게 많아졌다.
 *  - 직접 그리면서 백트래킹을 추적하면서 감을 계속 익히자
 * */

public class Main {

    static int n, m, answer = 0;
    static int[][] graph;
    static boolean[] visited;

    public static void dfs(int v) {
        if(v == n) {
            answer++;
        }else {
            for(int i = 1; i <= n; i++) {
                if(!visited[i] && graph[v][i] == 1) {
                    visited[i] = true;
                    dfs(i);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
        visited[1] = true;
        dfs(1);
        System.out.print(answer);
    }
}






























public class Main {

    static int n, m, answer = 0;
    static boolean[] visited;
    static int[][] graph;

    static public void dfs(int v) {
        if(v == n) {
            answer++;
        }else {
            for(int i = 1; i <= n; i++) {
                if(graph[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dfs(i);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
        }
        visited[1] = true;
        dfs(1);
        System.out.print(answer);
    }
}