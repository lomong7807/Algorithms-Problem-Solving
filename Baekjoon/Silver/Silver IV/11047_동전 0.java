import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 동전 0
 *  - 번호 : 11047
 *  - 링크 : https://www.acmicpc.net/problem/11047
 * 2. 풀이핵심
 *  - 그리디 알고리즘
 * 3. 풀이후기
 *  - 어렵지 않은 문제였다.
 *  - 입력 받은 숫자들을 제일 큰 수부터 차례대로 나눠가면서 개수를 추가하면 됨
 */

public class Main {

    public static int solution(int n, int k, int[] arr) {
        int answer = 0;

        for(int i = n - 1; 0 <= i; i--) {
            int x = arr[i];

            if(k != 0 && x <= k) {
                int y = k / x;
                answer += y;
                k -= x * y;
                if(k == 0) break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(solution(n, k, arr));
    }
}