import java.io.*;
import java.util.*;
/**
 * 1. 문제정보
 *  - 제목 : 1로 만들기
 *  - 번호 : 1463
 *  - 링크 : https://www.acmicpc.net/problem/1463
 * 2. 풀이핵심
 *  - 맵
 * 3. 풀이후기
 *  - 어렵지 않은 문제였음
 */

public class Main {

    public static int solution(int n) {
        int answer = 0;

        while(1 < n) {
            if((n - 1) % 3 == 0) {
                n -= 1;
            }else if((n - 1) % 2 == 0) {
                n -= 1;
            }else if(n % 3 == 0) {
                n = n / 3;
            }else if(n % 2 == 0) {
                n = n / 2;
            }else {
                n -= 1;
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(solution(n));
    }
}