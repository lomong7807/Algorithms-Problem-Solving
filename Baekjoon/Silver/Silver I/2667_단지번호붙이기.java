import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 단지번호붙이기
 *  - 번호 : 2667
 *  - 링크 : https://www.acmicpc.net/problem/2667
 * 2. 풀이핵심
 *  - dfs / bfs
 * 3. 풀이후기
 *  - 지난번 1012_유기농 배추문제는 bfs로 풀었어서 똑같이 bfs로 풀었는데 dfs 코드가 확실히 더 간단하다.
 *  - 범위가 작을때는 dfs로 구현하는게 맞을듯.. 아래에 bfs 풀이 방식도 남겨뒀다.
 *  - 그리고 이렇게 0과 1로 체크하는 map과 같은 경우는 굳이 visited를 사용하지 않고, map만으로 구현할 수도 있다.
 *  - map에서 방문한 곳을 다시 0으로 바꾸면 다음번에 방문할 일이 없음
 *  - 그래서 map의 타입도 int에서 boolean으로 바꿔 배열의 메모리 75% 절약
 */

// dfs
public class Main {

    static int n, size;
    static boolean[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void dfs(int x, int y) {
        map[x][y] = false;
        size++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < n && 0 <= ny && ny < n) {
                if(map[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        map = new boolean[n][n];
        List<int[]> points = new ArrayList<>();

        for(int x = 0; x < n; x++) {
            String tmp = br.readLine();
            for(int y = 0; y < n; y++) {
                if(tmp.charAt(y) == '1') {
                    map[x][y] = true;
                    points.add(new int[]{x, y});
                }
            }
        }

        for(int[] p : points) {
            int x = p[0];
            int y = p[1];
            if(map[x][y]) {
                size = 0;
                dfs(x, y);
                answer.add(size);
            }
        }

        Collections.sort(answer);

        sb.append(answer.size()).append("\n");
        for(int a : answer) {
            sb.append(a).append("\n");
        }

        System.out.print(sb);
    }
}



// bfs
public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void bfs(int x, int y) {
        Deque<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{x, y});
        visited[x][y] = true;
        int size = 1;

        while(!Q.isEmpty()) {
            int[] cur = Q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || n <= nx || ny < 0 || n <= ny) continue;

                if(map[nx][ny] == 1 && !visited[nx][ny]) {
                    Q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }
        answer.add(size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        List<int[]> points = new ArrayList<>();

        for(int x = 0; x < n; x++) {
            String tmp = br.readLine();
            for(int y = 0; y < n; y++) {
                if(tmp.charAt(y) == '1') {
                    map[x][y] = 1;
                    points.add(new int[]{x, y});
                }
            }
        }

        for(int[] p : points) {
            int x = p[0];
            int y = p[1];
            if(!visited[x][y]) {
                bfs(x, y);
            }
        }

        Collections.sort(answer);

        sb.append(answer.size()).append("\n");
        for(int a : answer) {
            sb.append(a).append("\n");
        }
        
        System.out.print(sb);
    }
}