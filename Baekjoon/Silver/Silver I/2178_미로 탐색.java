import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 미로 탐색
 *  - 번호 : 2178
 *  - 링크 : https://www.acmicpc.net/problem/2178
 * 2. 풀이핵심
 *  - bfs
 * 3. 풀이후기
 *  - 4방향으로 탐색하는 최단 거리 찾기는 bfs로 구현하자.
 *  - bfs는 조금 익숙해졌다.
 *  - 근데 항상 map의 범위를 벗어나는지 체크하는 확인을 깜빡한다. 잊지 말자.
 */

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void bfs(int x, int y) {
        Deque<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{x, y});
        map[x][y] = 0;
        dist[x][y] = 1;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                int[] cur = Q.poll();

                for(int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if(nx <= n && 0 < nx && ny <= m && 0 < ny && map[nx][ny] == 1) {
                        Q.add(new int[]{nx, ny});
                        map[nx][ny] = 0;
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;

                        if(nx == n && ny == m) break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        dist = new int[n + 1][m + 1];


        for(int x = 1; x <= n; x++) {
            char[] arr = br.readLine().toCharArray();
            for(int y = 0; y < m; y++) {
                if(arr[y] == '1') map[x][y + 1] = 1;
            }
        }

        bfs(1, 1);

        System.out.print(dist[n][m]);
    }
}