import java.io.*;
import java.util.*;
/*
 * 문제: 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
        경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
        출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
        격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
        0 0 0 0 0 0 0
        0 1 1 1 1 1 0
        0 0 0 1 0 0 0
        1 1 0 1 0 1 1
        1 1 0 1 0 0 0
        1 0 0 0 1 0 0
        1 0 1 0 0 0 0
        위와 같은 경로가 최단 경로의 길이는 12이다.
 * 입력: 첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
 * 출력: 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
 * 풀이후기:
 *  - bfs 최단거리문제 기본
 *  - bfs는 자신 있었는데 지난주에 과제하느라 코테 조금 안봤다고 헷갈렸다;
 *  - 꾸준히 문제를 풀자.
 *  - 방문했는지 체크는 따로 변수를 두지 않아도 된다. 해당 위치를 1으로 바꿔주면 어차피 방문 못함
 * */

public class Main {

    static int m, n, quantity, L;
    static int[][] map;
    static Deque<int[]> Q = new ArrayDeque<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void bfs() {

        L = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                int[] cur = Q.poll();

                for(int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if(nx < 0 || m <= nx || ny < 0 || n <= ny || map[nx][ny] != 0) {
                        continue;
                    }

                    Q.add(new int[]{nx, ny});
                    map[nx][ny] = 1;
                    quantity--;
                }
            }
            L++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        for(int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < m; x++) {
                map[x][y] = Integer.parseInt(st.nextToken());

                if(map[x][y] == 0) {
                    quantity++;
                }else if(map[x][y] == 1) {
                    Q.add(new int[]{x, y});
                }
            }
        }

        bfs();

        if(0 < quantity) {
            System.out.print(-1);
        }else {
            System.out.print(L);
        }
    }
}