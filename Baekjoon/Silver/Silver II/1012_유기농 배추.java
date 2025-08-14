import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 유기농 배추
 *  - 번호 : 1012
 *  - 링크 : https://www.acmicpc.net/problem/1012
 * 2. 풀이핵심
 *  - dfs/bfs
 * 3. 풀이후기
 *  - 예전에 유튜브에서 네 방향으로 확인하는 알고리즘을 봤던게 기억나서 풀 수 있었음.
 *  - 아마 그거 안봤으면 어떻게 해야 될지 고민을 많이 했을거 같다.
 *  - 처음에 Point라는 객체를 만들어서 구현했는데 굳이 필요없을거 같아서 int 배열로 받는거로 변경함
 *  - 해당 문제는 최단 거리나 단계별 정보가 필요 없기 때문에 레벨별 처리가 불필요함
 *  - 제일 처음 풀었던 코드에서 네번정도 리팩토링하니까 이제야 마음에 든다.
 */

public class Main {

    static int m, n, answer;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};

    public static void bfs(int x, int y) {
        Deque<int[]> Q = new ArrayDeque<>();
        Q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!Q.isEmpty()) {
            int[] cur = Q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int j = 0; j < 4; j++) {
                int nx = cx + dx[j];
                int ny = cy + dy[j];

                if(nx < 0 || m <= nx || ny < 0 || n <= ny) {
                    continue;
                }

                if(!visited[nx][ny] && board[nx][ny] == 1) {
                    Q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            answer = 0;
            int k = Integer.parseInt(st.nextToken());

            board = new int[m][n];
            visited = new boolean[m][n];
            List<int[]> list = new ArrayList<>();

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[x][y] = 1;
                list.add(new int[]{x, y});
            }

            for(int[] point : list) {
                int x = point[0];
                int y = point[1];
                if(!visited[x][y]) {
                    bfs(x, y);
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }
}