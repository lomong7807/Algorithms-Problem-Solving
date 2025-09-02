import java.io.*;
import java.util.*;
/*
 * 문제: 토마토 문제
 * 입력: 첫 줄에는 상자의 크기를 나타내는 두 정수 M, N이 주어진다. M은 상자의 가로 칸의 수,
        N 은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M, N ≤ 1,000 이다.
        둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
        즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
        하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
        정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 * 출력: 여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
        만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
        토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
 * 풀이후기:
 *  - bfs 토마토 문제
 *  - 익은 토마토들 주변으로 바로 시작하기 때문에 처음에 익어있는 토마토들을 모두 담아두고 시작해야한다.
 * */

public class Main {

    static int m, n, quantity, L;
    static int[][] map;
    static Deque<int[]> Q = new ArrayDeque<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void bfs() {

        L = 0;
        while(!Q.isEmpty() && 0 < quantity) {
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

        System.out.println(0 < quantity ? -1 : L);
    }
}