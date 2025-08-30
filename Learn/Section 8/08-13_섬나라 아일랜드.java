import java.io.*;
import java.util.*;
/*
 * 문제: N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
        각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
        섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
        1 1 0 0 0 1 0
        0 1 1 0 1 1 0
        0 1 0 0 0 0 0
        0 0 0 1 0 1 1
        1 1 0 1 1 0 0
        1 0 0 0 1 0 0
        1 0 1 0 1 0 0
 * 입력: 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
        두 번째 줄부터 격자판 정보가 주어진다.
 * 출력: 첫 번째 줄에 섬의 개수를 출력한다.
 * 풀이후기:
 *  -
 * */

public class Main {

    static int n, L;
    static int[][] map;
    static List<int[]> points = new ArrayList<>();
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};


    public static void bfs(int x, int y) {
        Deque<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{x, y});
        map[x][y] = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                int[] cur = Q.poll();

                for(int j = 0; j < 8; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if(nx < 0 || n <= nx || ny < 0 || n <= ny || map[nx][ny] == 0) {
                        continue;
                    }

                    Q.add(new int[]{nx, ny});
                    map[nx][ny] = 0;
                }
            }
        }

        L++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 0; x < n; x++) {
                map[x][y] = Integer.parseInt(st.nextToken());

                if(map[x][y] == 1) {
                    points.add(new int[]{x, y});
                }
            }
        }

        for(int[] p : points) {
            int x = p[0];
            int y = p[1];
            if(0 < map[x][y]) {
                bfs(x, y);
            }
        }

        System.out.print(L);
    }
}