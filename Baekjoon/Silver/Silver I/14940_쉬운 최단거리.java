import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 쉬운 최단거리
 *  - 번호 : 14940
 *  - 링크 : https://www.acmicpc.net/problem/14940
 * 2. 풀이핵심
 *  - bfs 최단거리
 * 3. 풀이후기
 *  - 이런 간단한 최단거리 문제는 이제 익숙해졌다.
 *  - 다만 이번 문제는 n값과 m값을 거꾸로 입력받아서 오류가 나던걸 못찾아서 헤맸다;
 *  - 문제를 잘 읽자
 */

public class Main {

    static int m, n;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void bfs(int x, int y) {
        Deque<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{x, y});
        map[x][y] = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                int[] cur = Q.remove();
                int cx = cur[0];
                int cy = cur[1];

                for(int j = 0; j < 4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];

                    if(nx < 0 || m <= nx || ny < 0 || n <= ny || map[nx][ny] < 1) {
                        continue;
                    }

                    Q.add(new int[]{nx, ny});
                    map[nx][ny] = 0;
                    dist[nx][ny] = dist[cx][cy] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        dist = new int[m][n];
        int startX = 0, startY = 0;

        for(int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < m; x++) {
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp == 2) {
                    startX = x;
                    startY = y;
                }
                map[x][y] = tmp;
            }
        }

        bfs(startX, startY);

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                if(map[x][y] == 1) {
                    sb.append(-1).append(" ");
                }else {
                    sb.append(dist[x][y]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}