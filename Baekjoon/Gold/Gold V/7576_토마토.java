import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 토마토
 *  - 번호 : 7576
 *  - 링크 : https://www.acmicpc.net/problem/7576
 * 2. 풀이핵심
 *  - BFS로 동시에 퍼져나가는 토마토들을 레벨별로 처리
 *  - quantity로 익지 않은 토마토 개수를 추적하여 O(1) 종료 조건 확인
 * 3. 풀이후기
 *  - 시간복잡도: O(M*N), 공간복잡도: O(M*N)
 *  - 성능 최적화: quantity 추적 + int[] 사용
 */

public class Main {

    static int m, n, quantity, day;
    static int[][] map;
    static Deque<int[]> Q = new ArrayDeque<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static int bfs() {
        int day = 0;

        while(!Q.isEmpty() && 0 < quantity) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                int[] cur = Q.poll();

                for(int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if(0 <= nx && nx < m && 0 <= ny && ny < n) {
                        if(map[nx][ny] == 0) {
                            Q.add(new int[]{nx, ny});
                            map[nx][ny] = 1;
                            quantity--;
                        }
                    }
                }
            }
            day++;
        }
        return day;
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

        int answer = bfs();

        System.out.println(quantity == 0 ? answer : -1);
    }
}