import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 비밀번호 찾기
 *  - 번호 : 17219
 *  - 링크 : https://www.acmicpc.net/problem/17219
 * 2. 풀이핵심
 *  - 맵
 * 3. 풀이후기
 *  - 어렵지 않은 문제였음
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            String tmp = br.readLine();
            sb.append(map.get(tmp)).append("\n");
        }

        System.out.print(sb);
    }
}