import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 숨바꼭질
 *  - 번호 : 1697
 *  - 링크 : https://www.acmicpc.net/problem/1697
 * 2. 풀이핵심
 *  - 
 * 3. 풀이후기
 *  - 
 */

public class Main {

    static int k, answer;
    static int[] dist = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int[] d = {-1, 1};

    public static int bfs(int n) {
        Deque<Integer> Q = new ArrayDeque<>();
        Q.add(n);
        visited[n] = true;

        int L = 0;

        while(!Q.isEmpty()) {
            int len = Q.size();

            for(int i = 0; i < len; i++) {
                int cur = Q.poll();

                for(int j = 0; j < 3; j++) {
                    int pos;
                    if(j < 2) {
                        pos = cur + d[j];
                    }else {
                        pos = cur * 2;
                    }

                    if(pos < 0 || k < pos || visited[pos]) {
                        continue;
                    }

                    if(pos == k) {
                        return L + 1;
                    }

                    Q.add(pos);
                    visited[pos] = true;
                }
                L++;
            }
        }

        return L;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.print(bfs(n));
    }
}