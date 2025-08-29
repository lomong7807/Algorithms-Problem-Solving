import java.io.*;
import java.util.*;
/*
 * 문제: 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
        출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
        격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
        0 0 0 0 0 0 0
        0 1 1 1 1 1 0
        0 0 0 1 0 0 0
        1 1 0 1 0 1 1
        1 1 0 0 0 0 1
        1 1 0 1 1 0 0
        1 0 0 0 0 0 0
        위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
 * 입력: 7*7 격자판의 정보가 주어집니다.
 * 출력: 첫 번째 줄에 경로의 가지수를 출력한다.
 * 풀이후기:
 *  - 이런 길 찾기는 BFS로만 풀어봤는데 DFS도 풀만한거 같다.
 *  - DFS는 최대한 유형을 그냥 익히는 중이다.
 * */

public class Main {

    static int[][] map = new int[8][8];
    static int answer;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1 ,0, 0};

    public static void dfs(int x, int y) {
        if(x == 7 && y == 7) {
            answer++;
        }else {
            for(int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 1 || ny < 1 || 7 < nx || 7 < ny || map[nx][ny] == 1) {
                    continue;
                }

                map[nx][ny] = 1;
                dfs(nx, ny);
                map[nx][ny] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int y = 1; y <= 7; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 1; x <= 7; x++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        map[1][1] = 1;
        dfs(1, 1);

        System.out.print(answer);
    }
}