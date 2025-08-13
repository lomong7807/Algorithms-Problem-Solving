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
 *  - 이전에는 인접행렬으로 구현했는데, 인접행렬보다 인접그래프가 성능적으로 좀 더 낫다.
 *  - 인접행렬의 경우 모든 값을 확인해보는데, 인접그래프는 해당 정점과 연결된 정점만 확인한다.
 * */

public class Main {

    static int n;
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void dfs(int v) {
        if(v == n) {
            answer++;
        }else {
            for(int nv : graph.get(v)) {
                if(!visited[nv]) {
                    visited[nv] = true;
                    dfs(nv);
                    visited[nv] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
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