import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 설탕배달
 *  - 번호 : 2839
 *  - 링크 : https://www.acmicpc.net/problem/2839
 * 2. 풀이핵심
 *  - 수학
 * 3. 풀이후기
 *  - 수학적 사고가 매우 필요한 문제였음
 *  - 간단해 보이지만 최소한의 주머니를 위해 조건을 많이 생각해야 돼서 생각보다 어려웠다.
 *  - 반복문으로 5를 빼면서 계속 3으로 나눠줘도 되지만 그렇게 하면 O(N)의 시간복잡도가 나온다.
 *  - 아래처럼 규칙을 찾아 풀면 O(1)의 시간복잡도로 해결
 */

public class Main {

    public static int solution(int n) {
        int answer = 0;

        if(n == 4 || n == 7) {
            answer = -1;
        }else if(n % 5 == 0) {
            answer = n / 5;
        }else if(n % 5 == 1 || n % 5 == 3) {
            answer = (n / 5) + 1;
        }else if(n % 5 == 2 || n % 5 == 4) {
            answer = (n / 5) + 2;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(solution(n));
    }
}