import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 1, 2, 3 더하기
 *  - 번호 : 9095
 *  - 링크 : https://www.acmicpc.net/problem/9095
 * 2. 풀이핵심
 *  - 맵
 * 3. 풀이후기
 *  - 어렵지 않은 문제였음
 */

public class Main {

    public static void dfs(int L, int sum) {
        if(L == 2) {

        } else {
            for(int i = 1; i <= 3; i++) {
                dfs(i, sum);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            dfs(0, 0);
        }
    }
}